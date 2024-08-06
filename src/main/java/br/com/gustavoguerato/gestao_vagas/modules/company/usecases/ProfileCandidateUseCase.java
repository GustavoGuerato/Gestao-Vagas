package br.com.gustavoguerato.gestao_vagas.modules.company.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoguerato.gestao_vagas.exceptions.UserNotFoundException;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.gustavoguerato.gestao_vagas.modules.company.dto.ProfileCandidateResponseDTO;

@Service
public class ProfileCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        var candidateDTO = ProfileCandidateResponseDTO.builder().description(candidate.getDescription())
                .username(candidate.getUsername()).email(candidate.getEmail()).id(candidate.getId())
                .name(candidate.getName()).build();
        return candidateDTO;
    }
}
