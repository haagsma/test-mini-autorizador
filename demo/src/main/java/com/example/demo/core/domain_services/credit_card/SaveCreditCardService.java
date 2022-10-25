package com.example.demo.core.domain_services.credit_card;

import com.example.demo.core.domain.credit_card.CreditCard;
import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;

public interface SaveCreditCardService {

    CreditCard save(CreditCardInfoDTO creditCardInfoDTO) throws CreditCardExistsException;
}
