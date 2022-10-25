package com.example.demo.web.exception_handler.credit_card;

import com.example.demo.core.domain.error.ErrorResponse;
import com.example.demo.core.exception.credit_card.CardNumberInvalidException;
import com.example.demo.core.exception.credit_card.CreditCardExistsException;
import com.example.demo.core.exception.credit_card.CreditCardPasswordInvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerAdviceCreditCard extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerAdviceCreditCard.class);

    @ExceptionHandler(CreditCardExistsException.class)
    public ResponseEntity<?> creditCardExistsException(CreditCardExistsException exception) {
        logger.info(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse("CREDIT_CARD_EXISTS", exception.getMessage()));
    }

    @ExceptionHandler(value = CardNumberInvalidException.class)
    public ResponseEntity<?> cardNumberInvalidException(CardNumberInvalidException exception) {
        logger.info(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse("CARD_NUMBER_INVALID", "Credit card number is invalid."));
    }

    @ExceptionHandler(value = CreditCardPasswordInvalidException.class)
    public ResponseEntity<?> creditCardPasswordInvalidException(CreditCardPasswordInvalidException exception) {
        logger.info(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse("CREDIT_CARD_PASSWORD_INVALID", "Credit card number is invalid."));
    }
}
