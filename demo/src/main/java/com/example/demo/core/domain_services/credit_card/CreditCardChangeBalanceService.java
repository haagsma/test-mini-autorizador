package com.example.demo.core.domain_services.credit_card;

import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.exception.credit_card.NoAvailableAmountException;

import java.math.BigDecimal;

public interface CreditCardChangeBalanceService {

    void debit(CreditCard creditCard, BigDecimal amount) throws NoAvailableAmountException;
}
