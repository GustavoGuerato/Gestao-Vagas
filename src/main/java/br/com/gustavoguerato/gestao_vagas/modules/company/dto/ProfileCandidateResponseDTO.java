package br.com.gustavoguerato.gestao_vagas.modules.company.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "desenvolvedor java")
    private String description;
    @Schema(example = "gustavo")
    private String username;
    @Schema(example = "gustavo@gmail.com")
    private String email;
    private UUID id;
    @Schema(example = "gustavo souza")
    private String name;
}
