package br.com.gustavoguerato.gestao_vagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @OpenAPIDefinition(info = @Info(title = "Gestão de vagas", description = "API
// responsavel por gestão de vagas", version = "1"))
// @SecurityScheme(name = "jwt_auth", scheme = "bearer", bearerFormat = "JWT",
// type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class GestaoVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVagasApplication.class, args);
	}

}
