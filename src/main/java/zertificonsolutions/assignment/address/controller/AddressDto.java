package zertificonsolutions.assignment.address.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import zertificonsolutions.assignment.address.entity.Address;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
class AddressDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    @NotBlank
    private String firstName;
    @JsonProperty
    @NotBlank
    private String lastName;
    @JsonProperty
    @NotBlank
    @Email
    private String emailAddress;
    @JsonProperty
    @Past
    @NotNull
    private LocalDate dateOfBirth;
    @JsonProperty
    @NotBlank
    private String street;
    @JsonProperty
    @NotNull
    private Integer postalCode;
    @JsonProperty
    @NotBlank
    private String country;

    Address asAddress() {
        return new Address(firstName, lastName, emailAddress, dateOfBirth, street, postalCode, country);
    }

    static AddressDto convert(Address address) {
        return new AddressDto(address.getId(), address.getFirstName(), address.getLastName(), address.getEmailAddress(),
                address.getDateOfBirth(), address.getStreet(), address.getPostalCode(), address.getCountry());
    }

}
