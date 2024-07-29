package br.com.gustavoguerato.gestao_vagas.exceptions;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource){
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleMethodArgumentNotValidExpection(MethodArgumentNotValidException e) {
        List<ErrorMessageDTO>
        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
        });
    }
}
