package br.com.gustavoguerato.gestao_vagas.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {
    public static String objectToJSON(Object obj) throws JsonProcessingException {

        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
    }

    public static String GenerateToken(UUID idCompany) {
        Algorithm algorithm = Algorithm.HMAC256("Microsoft3_@131");

        var expiresIn = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create().withIssuer("Microsoft3").withExpiresAt(expiresIn)
                .withSubject(idCompany.toString())
                .withClaim("roles", Arrays.asList("COMPANY")).sign(algorithm);

        return token;
    }

    public static Object GenerateToken(UUID randomUUID, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GenerateToken'");
    }
}
