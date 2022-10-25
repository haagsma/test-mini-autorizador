package com.example.demo.core.application_services.credit_card;

import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ConsultBalanceCreditCardTest {

    @Autowired
    private CreatorCreditCardService creatorCreditCardService;

    @Autowired
    private ConsultBalanceCreditCardService consultBalanceCreditCardService;

    @Test
    public void consult_balance_by_card_number_success() throws CreditCardExistsException, CreditCardInvalidException, CreditCardNotFoundException {
        String cardNumber = "6549873025634551";
        this.creatorCreditCardService.create(CreditCardInfoDTO.builder()
                .numeroCartao(cardNumber)
                .senha("1234")
                .build());

        BigDecimal amount = consultBalanceCreditCardService.consultBalance(cardNumber);
        Assertions.assertEquals(new BigDecimal("500.00"), amount);
    }

    @Test
    public void consult_balance_credit_card_not_found() throws CreditCardExistsException, CreditCardInvalidException {
        this.creatorCreditCardService.create(CreditCardInfoDTO.builder()
                .numeroCartao("6249573025634551")
                .senha("1234")
                .build());

        Assertions.assertThrows(CreditCardNotFoundException.class, () -> consultBalanceCreditCardService.consultBalance("6549873025634552"));
    }
}
