package br.com.gustavoguerato.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "company")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank()
    @Pattern(regexp = "\\S+", message = "o campo(username) não pode conter espaços")
    private String username;

    @NotBlank
    private String name;

    @Email(message = "o campo(email) deve conter um email valido")
    private String email;

    @Length(min = 10, max = 100, message = "O campo senha deve ter entre 10 e 100 caracteres")
    private String password;
    private String website;
    private String descprition;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
