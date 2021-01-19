package zertificonsolutions.assignment.address.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "street")
    private String street;
    @Column(name = "postal_code")
    private Integer postalCode;
    @Column(name = "country")
    private String country;

    public Address(String firstName, String lastName, String emailAddress, LocalDate dateOfBirth, String street, Integer postalCode, String country) {
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.emailAddress = emailAddress.toLowerCase();
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.postalCode = postalCode;
        this.country = country;
    }

    public void updateFrom(Address updatedAddress) {
        this.firstName = updatedAddress.firstName != null ? updatedAddress.firstName.toLowerCase(): this.firstName;
        this.lastName = updatedAddress.lastName != null ? updatedAddress.lastName.toLowerCase() : this.lastName;
        this.emailAddress = updatedAddress.emailAddress != null ? updatedAddress.emailAddress.toLowerCase() : this.emailAddress;
        this.dateOfBirth = updatedAddress.dateOfBirth != null ? updatedAddress.dateOfBirth : this.dateOfBirth;
        this.street = updatedAddress.street != null ? updatedAddress.street : this.street;
        this.postalCode = updatedAddress.postalCode != null ? updatedAddress.postalCode : this.postalCode;
        this.country = updatedAddress.country != null ? updatedAddress.country : this.country;
    }
}
