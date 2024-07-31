package br.com.gustavoguerato.gestao_vagas.modules.company.usecases;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gustavoguerato.gestao_vagas.modules.company.dto.AuthCompanyDto;
import br.com.gustavoguerato.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDto authCompanyDto) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDto.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Company not found");

        });
        var passwordMatches = this.passwordEncoder.matches(authCompanyDto.getPassword(), company.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }
    }
}
