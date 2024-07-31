package br.com.gustavoguerato.gestao_vagas.modules.company.usecases;

import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.gustavoguerato.gestao_vagas.modules.company.dto.AuthCompanyDto;
import br.com.gustavoguerato.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDto authCompanyDto) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDto.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/password Incorrect");

        });
        var passwordMatches = this.passwordEncoder.matches(authCompanyDto.getPassword(), company.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("Microsoft3").withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(company.getId().toString()).sign(algorithm);
        return token;
    }
}
