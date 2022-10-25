package com.example.demo.core.repository.credit_card;

import com.example.demo.core.domain.credit_card.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    CreditCard findByCardNumber(String cardNumber);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT c FROM CreditCard c WHERE c.cardNumber = :cardNumber")
    CreditCard findByCardNumberLock(String cardNumber);
}
