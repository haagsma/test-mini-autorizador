package com.example.demo.core.domain_services.credit_card.impl;

import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.domain_services.credit_card.SaveCreditCardService;
import com.example.demo.core.domain_services.password.PasswordManagerService;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.repository.credit_card.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveCreditCardServiceImpl implements SaveCreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final PasswordManagerService passwordManagerService;


    @Override
    public CreditCard save(CreditCardInfoDTO creditCardInfoDTO) throws CreditCardExistsException {
        CreditCard creditCard = creditCardRepository.findByCardNumber(creditCardInfoDTO.getNumeroCartao());
        if (creditCard != null) {
            throw new CreditCardExistsException("Credit card already exists");
        }
        return creditCardRepository.save(CreditCard.builder()
                        .balance(new BigDecimal(500))
                        .cardNumber(creditCardInfoDTO.getNumeroCartao())
                        .password(passwordManagerService.encode(creditCardInfoDTO.getSenha()))
                .build());
    }
}
