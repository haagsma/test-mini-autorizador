package com.example.demo.core.application_services.credit_card;

import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.exception.credit_card.CardNumberInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardPasswordInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateCreditCardTest {

    @Autowired
    private CreatorCreditCardService creatorCreditCardService;

    @Test
    public void create_new_credit_card_with_success() throws CreditCardInvalidException, CreditCardExistsException {

        this.creatorCreditCardService.create(CreditCardInfoDTO.builder()
                .numeroCartao("6549873025234501")
                .senha("1234")
                .build());
    }

    @Test
    public void create_new_credit_card_with_number_card_invalid() {
        Assertions.assertThrows(CardNumberInvalidException.class, () -> this.creatorCreditCardService.create(CreditCardInfoDTO.builder()
                .numeroCartao("654987202563451")
                .senha("1234")
                .build()));
    }

    @Test
    public void create_new_credit_card_with_password_invalid() {
        Assertions.assertThrows(CreditCardPasswordInvalidException.class, () -> this.creatorCreditCardService.create(CreditCardInfoDTO.builder()
                .numeroCartao("6549872025634501")
                .senha("12341")
                .build()));
    }
}
