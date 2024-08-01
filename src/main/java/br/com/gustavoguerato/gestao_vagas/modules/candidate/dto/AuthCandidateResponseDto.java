package br.com.gustavoguerato.gestao_vagas.modules.candidate.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCandidateResponseDto {

    private String access_token;
    private Long expires_in;
}
