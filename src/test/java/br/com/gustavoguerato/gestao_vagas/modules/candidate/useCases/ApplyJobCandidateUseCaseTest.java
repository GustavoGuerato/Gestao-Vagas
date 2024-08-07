package br.com.gustavoguerato.gestao_vagas.modules.candidate.useCases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gustavoguerato.gestao_vagas.exceptions.JobNotFoundException;
import br.com.gustavoguerato.gestao_vagas.exceptions.UserNotFoundException;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.UseCases.ApplyJobCandidateUseCase;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.gustavoguerato.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.gustavoguerato.gestao_vagas.modules.company.entities.JobEntity;
import br.com.gustavoguerato.gestao_vagas.modules.company.repositories.JobRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;
    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply job withe user not found")
    public void shouldNotBeAbleToApllyJobWithUserNotFound() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }

    }

    @Test
    public void shouldNotBeAbleToApllyJobWithJobNotFound() {
        var idCandidate = UUID.randomUUID();

        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }

    @Test
    public void shouldCreateANewJobApplication() {
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));
        when(applyJobRepository.save(any(ApplyJobEntity.class))).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate, idJob);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull();
    }
}
