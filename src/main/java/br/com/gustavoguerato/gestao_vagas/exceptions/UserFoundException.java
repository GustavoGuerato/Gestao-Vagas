package br.com.gustavoguerato.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("usuario já existe");
    }
}
