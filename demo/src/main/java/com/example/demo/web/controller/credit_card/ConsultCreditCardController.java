package com.example.demo.web.controller.credit_card;

import com.example.demo.core.application_services.credit_card.ConsultBalanceCreditCardService;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConsultCreditCardController {

    private final ConsultBalanceCreditCardService consultBalanceCreditCardService;

    @GetMapping("/cartoes/{numeroCartao}")
    public BigDecimal getBalance(@PathVariable String numeroCartao) throws CreditCardInvalidException, CreditCardNotFoundException {
        return consultBalanceCreditCardService.consultBalance(numeroCartao);
    }
}
