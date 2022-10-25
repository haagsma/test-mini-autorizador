package com.example.demo.core.domain_services.credit_card.impl;

import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.domain.credit_card.RedisCreditCard;
import com.example.demo.core.domain_services.credit_card.GetBalanceCreditCardService;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import com.example.demo.core.repository.credit_card.CreditCardRepository;
import com.example.demo.core.repository.credit_card.RedisCreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetBalanceCreditCardServiceImpl implements GetBalanceCreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final RedisCreditCardRepository redisCreditCardRepository;

    @Override
    public BigDecimal consultBalance(String cardNumber) throws CreditCardNotFoundException {
        RedisCreditCard redisCreditCard = redisCreditCardRepository.findByCardNumber(cardNumber);
        if (redisCreditCard != null) {
            System.out.println("pegou do redis");
            return redisCreditCard.getBalance();
        }
        CreditCard creditCard = creditCardRepository.findByCardNumber(cardNumber);
        if (creditCard == null) {
            throw new CreditCardNotFoundException("Credit Card not found with number: " + cardNumber);
        }
        redisCreditCardRepository.save(RedisCreditCard.fromCreditCard(creditCard));
        return creditCard.getBalance();
    }
}
