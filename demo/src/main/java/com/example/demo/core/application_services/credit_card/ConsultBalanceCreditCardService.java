package com.example.demo.core.application_services.credit_card;

import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;

import java.math.BigDecimal;

public interface ConsultBalanceCreditCardService {

    BigDecimal consultBalance(String cardNumber) throws CreditCardInvalidException, CreditCardNotFoundException;
}
