package com.example.demo.core.application_services.credit_card.impl;

import com.example.demo.core.application_services.credit_card.CreatorCreditCardService;
import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.domain_services.credit_card.SaveCreditCardService;
import com.example.demo.core.domain_services.credit_card.SaveCreditCardValidatorService;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.core.domain.credit_card.CreditCard;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreatorCreditCardServiceImpl implements CreatorCreditCardService {

    private final List<SaveCreditCardValidatorService> saveCreditCardValidatorServiceList;
    private final SaveCreditCardService saveCreditCardService;

    @Override
    public void create(CreditCardInfoDTO creditCardInfoDTO) throws CreditCardInvalidException, CreditCardExistsException {

        for (SaveCreditCardValidatorService validatorService: saveCreditCardValidatorServiceList) {
            validatorService.validate(creditCardInfoDTO);
        }

        CreditCard creditCard = saveCreditCardService.save(creditCardInfoDTO);

    }
}
