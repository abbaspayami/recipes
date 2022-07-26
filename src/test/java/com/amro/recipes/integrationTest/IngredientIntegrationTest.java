package com.amro.recipes.integrationTest;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dto.IngredientDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class IngredientIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();



    @Nested
    class TestNest {
        /**
         * Create new game before each test
         *
         * @throws Exception
         */
        @BeforeEach
        void createNewIngredient() throws Exception {
            MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/api/v1/ingredients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(IngredientIntegrationTest.asJsonString(TestUtils.againIngredientDto())))
                    .andExpect(status().isCreated())
                    .andReturn();

            assertNotNull(mvcResult.getResponse());
            assertNotNull(mvcResult.getResponse().getContentAsString());

        }

//        @ParameterizedTest
//        @ValueSource(ints = {1})
//        void ingredient_Update_Test(int id) throws Exception {
//            mockMvc.perform(put("http://localhost:8080/api/v1/ingredients/update/" + id)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(IngredientIntegrationTest.asJsonString(TestUtils.ingredientDto())))
//                    .andExpect(status().isOk());
//        }

        @Test
        void saveAlreadyExist_Ingredient_Test() throws Exception {
            mockMvc.perform(post("http://localhost:8080/api/v1/ingredients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(IngredientIntegrationTest.asJsonString(TestUtils.ingredientDto())))
                    .andExpect(status().isBadRequest());
        }
    }

    @Test
    void save_Ingredient_Test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/api/v1/ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.asJsonString(TestUtils.ingredientDto())))
                .andExpect(status().isCreated())
                .andReturn();

        assertNotNull(mvcResult.getResponse());
        assertNotNull(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getAll_Ingredient_Test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/api/v1/ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(TestUtils.ingredientDto())))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(mvcResult.getResponse());
        assertNotNull(mvcResult.getResponse().getContentAsString());
    }

    public static String asJsonString(IngredientDto ingredientDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(ingredientDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
