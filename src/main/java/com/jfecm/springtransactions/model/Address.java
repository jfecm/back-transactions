package com.jfecm.springtransactions.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Represents an address entity.
 * The fields of the address include:
 * - {@code street}: The street name of the address.
 * - {@code city}: The city of the address.
 * - {@code country}: The country of the address.
 * - {@code postalCode}: The postal code of the address.
 */
@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false, name = "postal_code")
    private String postalCode;

}
