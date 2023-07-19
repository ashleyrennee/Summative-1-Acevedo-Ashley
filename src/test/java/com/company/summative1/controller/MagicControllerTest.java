package com.company.summative1.controller;

import com.company.summative1.model.Answer;
import com.company.summative1.model.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MagicController.class)
class MagicControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private List<Answer> possibleAnswers;
    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void getMagicAnswer_ShouldReturnAnswer() throws Exception {
        String outputAns = objectMapper.writeValueAsString(possibleAnswers);

        mockMvc.perform(get("/magic"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getMagicAnswer_ShouldReturnAnswerGivenQuestion() throws Exception {
        String outputAns = objectMapper.writeValueAsString(possibleAnswers);

        mockMvc.perform(get("/magic/will i be happy"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
