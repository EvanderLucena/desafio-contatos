package com.evander.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "Street of the address", example = "123 Main Street")
    @NotNull(message = "Street is required")
    @Size(min = 1, message = "Street is required")
    private String street;

    @ApiModelProperty(value = "Number of the address", example = "456")
    @NotNull(message = "Number is required")
    @Size(min = 1, message = "Number is required")
    private String number;

    @ApiModelProperty(value = "Zip code of the address", example = "12345")
    @NotNull
    private String zipCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    @Valid
    private Contact contact;
}
