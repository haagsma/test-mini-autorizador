package com.example.demo.core.dto.credit_card;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreditCardInfoDTO {

    private String numeroCartao;
    private String senha;
}
