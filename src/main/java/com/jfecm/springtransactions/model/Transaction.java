package com.jfecm.springtransactions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * Represents a transaction entity.
 * The fields of the transaction include:
 * - {@code amount}: The amount of the transaction.
 * - {@code currencyFrom}: The currency from which the amount is transferred.
 * - {@code currencyTo}: The currency to which the amount is transferred.
 * - {@code status}: The status of the transaction.
 * - {@code startDate}: The start date of the transaction.
 * - {@code completionDate}: The completion date of the transaction (optional).
 * - {@code customer}: The customer associated with the transaction.
 */
@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Column(nullable = false)
    private Float amount;

    @Column(nullable = false, name = "currency_from")
    private String currencyFrom;

    @Column(nullable = false, name = "currency_to")
    private String currencyTo;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(nullable = false, name = "start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime completionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

}
