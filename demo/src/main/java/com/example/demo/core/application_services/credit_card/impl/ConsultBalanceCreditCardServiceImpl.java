package com.example.demo.core.application_services.credit_card.impl;

import com.example.demo.core.application_services.credit_card.ConsultBalanceCreditCardService;
import com.example.demo.core.domain_services.credit_card.GetBalanceCreditCardService;
import com.example.demo.core.domain_services.credit_card.SaveCreditCardValidatorService;
import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsultBalanceCreditCardServiceImpl implements ConsultBalanceCreditCardService {

    @Autowired
    @Qualifier("saveCreditCardNumberValidatorService")
    private SaveCreditCardValidatorService creditCardValidatorService;

    @Autowired
    private GetBalanceCreditCardService getBalanceCreditCardService;


    @Override
    public BigDecimal consultBalance(String cardNumber) throws CreditCardInvalidException, CreditCardNotFoundException {
        creditCardValidatorService.validate(CreditCardInfoDTO.builder()
                        .numeroCartao(cardNumber)
                .build());
        return getBalanceCreditCardService.consultBalance(cardNumber);
    }
}
