package br.com.gustavoguerato.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavoguerato.gestao_vagas.modules.company.entities.JobEntity;
import br.com.gustavoguerato.gestao_vagas.modules.company.entities.JobEntity.JobEntityBuilder;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    JobEntity saveAll(JobEntityBuilder jobEntity);

}