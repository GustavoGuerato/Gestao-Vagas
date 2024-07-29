package br.com.gustavoguerato.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    @Pattern(regexp = "^(?!!\\s*$).+", message = "o campo(username) não pode conter espaços")
    private String username;
    @Email(message = "o campo(email) deve conter um email valido")
    private String email;
    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculo;

}
