package com.example.demo.core.domain_services.credit_card.impl;

import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.domain_services.credit_card.CreditCardChangeBalanceService;
import com.example.demo.core.exception.credit_card.NoAvailableAmountException;
import com.example.demo.core.repository.credit_card.CreditCardRepository;
import com.example.demo.core.repository.credit_card.RedisCreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreditCardChangeBalanceServiceImpl implements CreditCardChangeBalanceService {

    private final CreditCardRepository creditCardRepository;
    private final RedisCreditCardRepository redisCreditCardRepository;

    @Override
    @Transactional
    public void debit(CreditCard creditCard, BigDecimal amount) throws NoAvailableAmountException {
        if (!creditCard.hasAvailableAmount(amount)) {
            throw new NoAvailableAmountException("No available amount to transaction");
        }

        creditCard.debitBalance(amount);

        creditCardRepository.save(creditCard);

        redisCreditCardRepository.deleteById(creditCard.getId());
    }
}
