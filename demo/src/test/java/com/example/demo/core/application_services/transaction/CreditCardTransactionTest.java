package com.example.demo.core.application_services.transaction;

import com.example.demo.core.application_services.credit_card.CreatorCreditCardService;
import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.dto.transaction.TransactionDTO;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import com.example.demo.core.exception.credit_card.NoAvailableAmountException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class CreditCardTransactionTest {

    @Autowired
    private CreatorCreditCardService creatorCreditCardService;

    @Autowired
    private TransactionFlowService transactionFlowService;

    @Test
    public void recieve_transaction_with_success() throws CreditCardInvalidException, CreditCardNotFoundException, CreditCardExistsException, NoAvailableAmountException {
        this.creatorCreditCardService.create(CreditCardInfoDTO.builder()
                .numeroCartao("6549873525634501")
                .senha("1234")
                .build());

        transactionFlowService.receiveTransaction(TransactionDTO.builder()
                        .numeroCartao("6549873525634501")
                        .senhaCartao("1234")
                        .valor(new BigDecimal(10))
                .build());
    }
}
