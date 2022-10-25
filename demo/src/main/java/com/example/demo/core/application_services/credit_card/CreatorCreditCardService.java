package com.example.demo.core.application_services.credit_card;

import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;

public interface CreatorCreditCardService {

    void create(CreditCardInfoDTO creditCardInfoDTO) throws CreditCardInvalidException, CreditCardExistsException;
}
