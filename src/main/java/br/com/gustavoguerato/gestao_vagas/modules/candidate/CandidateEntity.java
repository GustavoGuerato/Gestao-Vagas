package br.com.gustavoguerato.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Gustavo Guerato", requiredMode = RequiredMode.REQUIRED)
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "o campo(username) não pode conter espaços")
    @Schema(example = "Guerato", requiredMode = RequiredMode.REQUIRED)
    private String username;

    @Email(message = "o campo(email) deve conter um email valido")
    @Schema(example = "gustavo@gmail.com", requiredMode = RequiredMode.REQUIRED)
    private String email;

    @Length(min = 10, max = 100, message = "O campo senha deve ter entre 10 e 100 caracteres")
    @Schema(example = "senha1234567", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha do candidato")
    private String password;
    @Schema(example = "Java Developer", description = "breve Descricao do candidato")
    private String description;
    private String curriculo;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
