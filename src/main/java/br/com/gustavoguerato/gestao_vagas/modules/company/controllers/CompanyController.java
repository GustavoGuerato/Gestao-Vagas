package br.com.gustavoguerato.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoguerato.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.gustavoguerato.gestao_vagas.modules.company.usecases.CreateCompanyUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    @SecurityRequirement(name = "jwt_auth")

    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
