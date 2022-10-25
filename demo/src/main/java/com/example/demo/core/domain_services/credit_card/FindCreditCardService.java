package com.example.demo.core.domain_services.credit_card;

import com.example.demo.core.domain.credit_card.CreditCard;

public interface FindCreditCardService {

    CreditCard byCardNumberToUpdate(String cardNumber);
}
