package com.jfecm.springtransactions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a customer entity.
 * The fields of the customer include:
 * - {@code name}: The name of the customer.
 * - {@code lastName}: The last name of the customer.
 * - {@code documentNumber}: The unique document number associated with the customer.
 * - {@code email}: The unique email address of the customer.
 * - {@code dateOfBirth}: The date of birth of the customer.
 * - {@code address}: The address associated with the customer.
 * - {@code transactions}: The set of transactions associated with the customer.
 */
@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true, name = "document_number")
    private String documentNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "date_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<>();

}
