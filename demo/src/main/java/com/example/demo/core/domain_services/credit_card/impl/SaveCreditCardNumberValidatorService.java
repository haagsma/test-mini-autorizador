package com.example.demo.core.domain_services.credit_card.impl;

import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.domain_services.credit_card.SaveCreditCardValidatorService;
import com.example.demo.core.exception.credit_card.CardNumberInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import org.springframework.stereotype.Service;

@Service
public class SaveCreditCardNumberValidatorService implements SaveCreditCardValidatorService {

    @Override
    public void validate(CreditCardInfoDTO creditCardInfoDTO) throws CreditCardInvalidException {
        String creditCardNumber = creditCardInfoDTO.getNumeroCartao().replace("[^\\d]", "");
        if (creditCardNumber.length() != 16) {
            throw new CardNumberInvalidException("Card number contains " + creditCardNumber.length() + " numbers");
        }
    }
}
