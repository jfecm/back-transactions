package com.jfecm.springtransactions.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime startDate;

    @Column
    private LocalDateTime completionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

}
