package com.example.demo.core.repository.credit_card;

import com.example.demo.core.domain.credit_card.RedisCreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisCreditCardRepository extends CrudRepository<RedisCreditCard, Long> {

    RedisCreditCard findByCardNumber(String cardNumber);
}
