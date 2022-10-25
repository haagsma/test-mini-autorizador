package com.example.demo.core.repository.credit_card;

import com.example.demo.core.domain.credit_card.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    CreditCard findByCardNumber(String cardNumber);
}
