package com.example.demo.core.dto.transaction;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class TransactionDTO {

    private String numeroCartao;
    private String senhaCartao;
    private BigDecimal valor;
}
