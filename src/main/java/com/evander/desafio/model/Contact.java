package com.evander.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Size(min = 1, message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(min = 1, message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Date of birth is required")
    @Size(min = 1, message = "Date of birth is required")
    private String dateOfBirth;

    @Valid
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("contact")
    private List<Address> addresses;

}
