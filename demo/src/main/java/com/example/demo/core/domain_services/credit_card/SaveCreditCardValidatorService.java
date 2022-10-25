package com.example.demo.core.domain_services.credit_card;

import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;

public interface SaveCreditCardValidatorService {

    void validate(CreditCardInfoDTO creditCardInfoDTO) throws CreditCardInvalidException;
}
