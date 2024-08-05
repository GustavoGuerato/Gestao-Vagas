package br.com.gustavoguerato.gestao_vagas.modules.company.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gustavoguerato.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.gustavoguerato.gestao_vagas.modules.company.dto.CreateJobDto;
import br.com.gustavoguerato.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.gustavoguerato.gestao_vagas.modules.company.repositories.CompanyRepository;
import br.com.gustavoguerato.gestao_vagas.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CreateJobControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CompanyRepository companyRepository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }

    @Test
    public void shouldbeAbleToCreateANewJob() throws JsonProcessingException, Exception {

        var company = CompanyEntity.builder().descprition("COMPANY_DESCRIPTION").email("email@company.com")
                .password("12345678910")
                .username("COMPANY_USERNAME").name("COMPANY_NAME").build();

        company = companyRepository.saveAndFlush(company);

        var createJobDto = CreateJobDto
                .builder().benefits("BENEFITS_TEST").description("DESCRIPTION_TEST").level("LEVEL_TEST").build();

        var result = mvc.perform(MockMvcRequestBuilders.post("/company/job/").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectToJSON(createJobDto))
                .header("Authorization", TestUtils.GenerateToken(company.getId(), "Microsoft3_@131")))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println(result);
    }

    public void shouldNotBeAbleToCreateANewJobIfCompanyNotFound() throws JsonProcessingException, Exception {
        var createJobDto = CreateJobDto
                .builder().benefits("BENEFITS_TEST").description("DESCRIPTION_TEST").level("LEVEL_TEST").build();
        try {
            mvc.perform(MockMvcRequestBuilders.post("/company/job/").contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtils.objectToJSON(createJobDto))
                    .header("Authorization", TestUtils.GenerateToken(UUID.randomUUID(), "Microsoft3_@131")));
        } catch (Exception e) {
            assertThat(e).isInstanceOf(CompanyNotFoundException.class);
        }

    }

}
