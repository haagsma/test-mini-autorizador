package com.example.demo.web.controller.credit_card;

import com.example.demo.core.application_services.credit_card.CreatorCreditCardService;
import com.example.demo.core.dto.credit_card.CreditCardInfoDTO;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.exception.credit_card.CreditCardInvalidException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateCreditCardController {

    private final CreatorCreditCardService creatorCreditCardService;

    @PostMapping("/cartoes")
    public ResponseEntity<CreditCardInfoDTO> registerNewCreditCard(@RequestBody CreditCardInfoDTO creditCardInfoDTO) throws CreditCardExistsException, CreditCardInvalidException {
        creatorCreditCardService.create(creditCardInfoDTO);
        creditCardInfoDTO.setSenha(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(creditCardInfoDTO);
    }
}
