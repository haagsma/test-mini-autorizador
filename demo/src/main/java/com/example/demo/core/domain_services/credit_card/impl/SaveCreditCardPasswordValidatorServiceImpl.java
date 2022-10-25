package com.example.demo.core.domain_services.credit_card.impl;

import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.domain_services.credit_card.SaveCreditCardValidatorService;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardPasswordInvalidException;
import org.springframework.stereotype.Service;

@Service
public class SaveCreditCardPasswordValidatorServiceImpl implements SaveCreditCardValidatorService {
    @Override
    public void validate(CreditCardInfoDTO creditCardInfoDTO) throws CreditCardInvalidException {
        if (creditCardInfoDTO.getSenha().length() != 4) {
            throw new CreditCardPasswordInvalidException("The credit Card Password does not have 4 digits");
        }
    }
}
