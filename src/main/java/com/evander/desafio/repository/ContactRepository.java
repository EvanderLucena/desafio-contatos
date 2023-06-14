package com.evander.desafio.repository;

import com.evander.desafio.model.Contact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @EntityGraph(attributePaths = "addresses")
    List<Contact> findAll();
}
