package com.example.demo.core.domain_services.credit_card.impl;

import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.domain_services.credit_card.FindCreditCardService;
import com.example.demo.core.repository.credit_card.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindCreditCardServiceImpl implements FindCreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Override
    @Transactional
    public CreditCard byCardNumberToUpdate(String cardNumber) {
        return creditCardRepository.findByCardNumberLock(cardNumber);
    }
}
