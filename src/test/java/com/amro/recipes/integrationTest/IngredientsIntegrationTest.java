package com.amro.recipes.integrationTest;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dto.IngredientDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application-test.properties")
public class IngredientsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void save_Ingredient_Test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/api/ingredient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.asJsonString(TestUtils.ingredientDto())))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(mvcResult.getResponse());
        assertNotNull(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void saveAlreadyExist_Ingredient_Test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/api/ingredient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.asJsonString(TestUtils.ingredientDto())))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(mvcResult.getResponse());
        assertNotNull(mvcResult.getResponse().getContentAsString());

        mockMvc.perform(post("http://localhost:8080/api/ingredient/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.asJsonString(TestUtils.ingredientDto())))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void getAll_Ingredient_Test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/ingredient/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.asJsonString(TestUtils.ingredientDto())))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(mvcResult.getResponse());
        assertNotNull(mvcResult.getResponse().getContentAsString());
    }

    public String asJsonString(IngredientDto ingredientDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(ingredientDto);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
