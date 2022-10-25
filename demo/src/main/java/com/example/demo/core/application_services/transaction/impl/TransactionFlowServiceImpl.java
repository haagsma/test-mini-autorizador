package com.example.demo.core.application_services.transaction.impl;

import com.example.demo.core.application_services.transaction.TransactionFlowService;
import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.domain_services.credit_card.CreditCardChangeBalanceService;
import com.example.demo.core.domain_services.credit_card.FindCreditCardService;
import com.example.demo.core.domain_services.credit_card.SaveCreditCardValidatorService;
import com.example.demo.core.domain_services.password.PasswordManagerService;
import com.example.demo.core.domain_services.transaction.TransactionHistService;
import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.dto.transaction.TransactionDTO;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import com.example.demo.core.exception.credit_card.CreditCardPasswordInvalidException;
import com.example.demo.core.exception.credit_card.NoAvailableAmountException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionFlowServiceImpl implements TransactionFlowService {

    private final List<SaveCreditCardValidatorService> saveCreditCardValidatorServiceList;
    private final PasswordManagerService passwordManagerService;
    private final FindCreditCardService findCreditCardService;
    private final CreditCardChangeBalanceService creditCardChangeBalanceService;
    private final TransactionHistService transactionHistService;

    @Override
    @Transactional
    public void receiveTransaction(TransactionDTO transactionDTO) throws CreditCardInvalidException, CreditCardNotFoundException, NoAvailableAmountException {
        for (SaveCreditCardValidatorService saveCreditCardValidatorService: saveCreditCardValidatorServiceList) {
            saveCreditCardValidatorService.validate(CreditCardInfoDTO.fromTransactionDTO(transactionDTO));
        }

        CreditCard creditCard = findCreditCardService.byCardNumberToUpdate(transactionDTO.getNumeroCartao());

        if (creditCard == null) {
            throw new CreditCardNotFoundException("Credit Card not found with number: " + transactionDTO.getNumeroCartao());
        }

        if (!passwordManagerService.verify(transactionDTO.getSenhaCartao(), creditCard.getPassword())) {
            throw new CreditCardPasswordInvalidException("The credit Card Password are incorrect");
        }

        BigDecimal oldAmount = creditCard.getBalance();

        creditCardChangeBalanceService.debit(creditCard, transactionDTO.getValor());

        transactionHistService.saveRecord(creditCard, oldAmount, transactionDTO.getValor());

    }
}
