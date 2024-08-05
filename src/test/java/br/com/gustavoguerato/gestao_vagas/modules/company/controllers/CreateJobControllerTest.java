package br.com.gustavoguerato.gestao_vagas.modules.company.controllers;

import javax.management.RuntimeErrorException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavoguerato.gestao_vagas.modules.company.dto.CreateJobDto;

public class CreateJobControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void shouldbeAbleToCreateANewJob() throws JsonProcessingException, Exception {

        var createJobDto = CreateJobDto
                .builder().benefits("BENEFITS_TEST").description("DESCRIPTION_TEST").level("LEVEL_TEST").build();

        var result = mvc.perform(MockMvcRequestBuilders.post("/company/job").contentType(MediaType.APPLICATION_JSON)
                .content(objectToJSON(createJobDto))).andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println(result);
    }

    private static String objectToJSON(Object obj) throws JsonProcessingException {

        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
    }
}
