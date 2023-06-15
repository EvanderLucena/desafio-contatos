package com.evander.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "Name of the contact", example = "John Doe")
    @NotBlank(message = "Name is required")
    private String name;

    @ApiModelProperty(value = "Email of the contact", example = "john.doe@example.com")
    @NotBlank(message = "Email is required")
    @Size(min = 1, message = "Email is required")
    private String email;

    @ApiModelProperty(value = "Phone number of the contact", example = "+1-123-456-7890")
    @NotBlank(message = "Phone number is required")
    @Size(min = 1, message = "Phone number is required")
    private String phoneNumber;

    @ApiModelProperty(value = "Date of birth of the contact", example = "1990-01-01")
    @NotBlank(message = "Date of birth is required")
    @Size(min = 1, message = "Date of birth is required")
    private String dateOfBirth;

    @Valid
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("contact")
    private List<Address> addresses;

}
