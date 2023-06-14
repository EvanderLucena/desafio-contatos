package com.evander.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Street is required")
    @Size(min = 1, message = "Street is required")
    private String street;

    @NotNull(message = "Number is required")
    @Size(min = 1, message = "Number is required")
    private String number;

    @NotNull
    private String zipCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    @Valid
    private Contact contact;
}
