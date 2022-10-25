package com.example.demo.core.dto.credit_card;

import com.example.demo.core.dto.transaction.TransactionDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreditCardInfoDTO {

    private String numeroCartao;
    private String senha;

    public static CreditCardInfoDTO fromTransactionDTO(TransactionDTO transactionDTO) {
        return CreditCardInfoDTO.builder()
                .numeroCartao(transactionDTO.getNumeroCartao())
                .senha(transactionDTO.getSenhaCartao())
                .build();
    }
}
