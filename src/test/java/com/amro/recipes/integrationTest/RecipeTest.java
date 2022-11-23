package com.amro.recipes.integrationTest;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.repository.FoodTypeRepository;
import com.amro.recipes.dto.RecipeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class RecipeTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    private Recipe recipe;

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Test
    void createNewRecipe() throws Exception {
        foodTypeRepository.save(TestUtils.newFoodType());
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/api/v1/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RecipeTest.asJsonString(TestUtils.recipeDto())))
                .andExpect(status().isCreated())
                .andReturn();

        assertNotNull(mvcResult.getResponse());
        assertNotNull(mvcResult.getResponse().getContentAsString());

    }

    public static String asJsonString(RecipeDto recipeDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(recipeDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
