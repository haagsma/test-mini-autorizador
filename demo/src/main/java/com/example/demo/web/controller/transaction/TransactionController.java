package com.example.demo.web.controller.transaction;

import com.example.demo.core.application_services.transaction.TransactionFlowService;
import com.example.demo.core.dto.transaction.TransactionDTO;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import com.example.demo.core.exception.credit_card.NoAvailableAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionFlowService transactionFlowService;

    @PostMapping("/transacoes")
    public ResponseEntity<?> transactionFlow(@RequestBody TransactionDTO transactionDTO) throws CreditCardInvalidException, CreditCardNotFoundException, NoAvailableAmountException {
        transactionFlowService.receiveTransaction(transactionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }
}
