package com.example.demo.core.domain_services.credit_card;

import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;

import java.math.BigDecimal;

public interface GetBalanceCreditCardService {

    BigDecimal consultBalance(String cardNumber) throws CreditCardNotFoundException;
}
