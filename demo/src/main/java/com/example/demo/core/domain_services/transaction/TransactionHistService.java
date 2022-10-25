package com.example.demo.core.domain_services.transaction;

import com.example.demo.core.domain.credit_card.CreditCard;

import java.math.BigDecimal;

public interface TransactionHistService {

    void saveRecord(CreditCard creditCard, BigDecimal oldAmount, BigDecimal amount);
}
