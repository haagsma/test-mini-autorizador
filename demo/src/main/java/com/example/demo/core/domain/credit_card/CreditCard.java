package com.example.demo.core.domain.credit_card;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_card")
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    private String password;

    private BigDecimal balance;



}
