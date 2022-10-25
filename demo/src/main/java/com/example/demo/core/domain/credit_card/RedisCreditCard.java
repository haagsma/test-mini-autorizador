package com.example.demo.core.domain.credit_card;


import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@RedisHash("RedisCreditCard")
@Data
public class RedisCreditCard {
    private Long id;
    private String cardNumber;
    private String password;
    private BigDecimal balance;

    public static RedisCreditCard fromCreditCard(CreditCard creditCard) {
        RedisCreditCard redisCreditCard = new RedisCreditCard();
        redisCreditCard.setId(creditCard.getId());
        redisCreditCard.setCardNumber(creditCard.getCardNumber());
        redisCreditCard.setBalance(creditCard.getBalance());
        return redisCreditCard;
    }



}
