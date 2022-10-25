package com.example.demo.core.domain_services.transaction.impl;

import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.domain.credit_card.TransactionHist;
import com.example.demo.core.domain_services.transaction.TransactionHistService;
import com.example.demo.core.repository.transaction.TransactionHistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionHistServiceImpl implements TransactionHistService {

    private final TransactionHistRepository transactionHistRepository;

    @Override
    @Transactional
    public void saveRecord(CreditCard creditCard, BigDecimal oldAmount, BigDecimal amount) {
        transactionHistRepository.save(TransactionHist.builder()
                        .creditCard(creditCard)
                        .amount(amount)
                        .oldAmount(oldAmount)
                        .date(new Date())
                .build());
    }
}
