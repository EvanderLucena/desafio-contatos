package com.evander.desafio.resource;

import com.evander.desafio.model.Address;
import com.evander.desafio.model.Contact;
import com.evander.desafio.repository.AddressRepository;
import com.evander.desafio.repository.ContactRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Contacts")
@Validated
@RequestMapping("/contacts")
public class ContactResource {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Contact> listContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
        Contact createdContact = contactRepository.save(contact);

        List<Address> addresses = contact.getAddresses();

        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                address.setContact(createdContact);
                addressRepository.save(address);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            Contact contact = existingContact.get();
            contact.setName(updatedContact.getName());
            contact.setEmail(updatedContact.getEmail());
            contact.setDateOfBirth(updatedContact.getDateOfBirth());
            contact.setPhoneNumber(updatedContact.getPhoneNumber());

            List<Address> existingAddresses = contact.getAddresses();
            List<Address> updatedAddresses = updatedContact.getAddresses();

            // Atualizar os Addresses individualmente
            for (int i = 0; i < updatedAddresses.size(); i++) {
                Address updatedAddress = updatedAddresses.get(i);
                if (i < existingAddresses.size()) {
                    // Atualizar um Address existente
                    Address existingAddress = existingAddresses.get(i);
                    existingAddress.setStreet(updatedAddress.getStreet());
                    existingAddress.setNumber(updatedAddress.getNumber());
                    existingAddress.setZipCode(updatedAddress.getZipCode());
                    addressRepository.save(existingAddress);
                } else {
                    // Adicionar um novo Address
                    updatedAddress.setContact(contact);
                    addressRepository.save(updatedAddress);
                    existingAddresses.add(updatedAddress);
                }
            }
            // Remover Address excedentes, se houver
            if (existingAddresses.size() > updatedAddresses.size()) {
                for (int i = updatedAddresses.size(); i < existingAddresses.size(); i++) {
                    Address addressToRemove = existingAddresses.get(i);
                    addressRepository.delete(addressToRemove);
                }
                existingAddresses.subList(updatedAddresses.size(), existingAddresses.size()).clear();
            }

            return ResponseEntity.ok(contactRepository.save(contact));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()){
            contactRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
