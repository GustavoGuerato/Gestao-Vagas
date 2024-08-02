package br.com.gustavoguerato.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoguerato.gestao_vagas.modules.company.dto.CreateJobDto;
import br.com.gustavoguerato.gestao_vagas.modules.company.entities.JobEntity;
import br.com.gustavoguerato.gestao_vagas.modules.company.usecases.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create(@Valid @RequestBody CreateJobDto createJobDto, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder().benefits(createJobDto.getBenefits())
                .companyId(UUID.fromString(companyId.toString()))
                .description(createJobDto.getDescription())
                .level(createJobDto.getLevel()).build();

        return this.createJobUseCase.execute(jobEntity);
    }
}
