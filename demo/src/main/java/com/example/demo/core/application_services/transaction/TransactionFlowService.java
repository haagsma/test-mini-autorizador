package com.example.demo.core.application_services.transaction;

import com.example.demo.core.dto.transaction.TransactionDTO;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import com.example.demo.core.exception.credit_card.NoAvailableAmountException;

public interface TransactionFlowService {

    void receiveTransaction(TransactionDTO transactionDTO) throws CreditCardInvalidException, CreditCardNotFoundException, NoAvailableAmountException;
}
