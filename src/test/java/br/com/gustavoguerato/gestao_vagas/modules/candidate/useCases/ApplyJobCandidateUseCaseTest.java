package br.com.gustavoguerato.gestao_vagas.modules.candidate.useCases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gustavoguerato.gestao_vagas.exceptions.UserNotFoundException;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.UseCases.ApplyJobCandidateUseCase;
import br.com.gustavoguerato.gestao_vagas.modules.company.repositories.JobRepository;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;
    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Should not be able to apply job withe user not found")
    public void shouldNotBeAbleToApllyJobWithUserNotFound() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }

    }
}
