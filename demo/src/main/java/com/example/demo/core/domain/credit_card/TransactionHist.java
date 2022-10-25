package com.example.demo.core.domain.credit_card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaction_history")
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class TransactionHist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    private Date date;

    private BigDecimal amount;

    @Column(name = "old_amount")
    private BigDecimal oldAmount;
}
