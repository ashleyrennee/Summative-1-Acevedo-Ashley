package com.company.summative1.controller;

import com.company.summative1.model.Answer;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MagicController.class)
class MagicControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private List<String> possibleAnswers;
    private static int idCounter = 0;
    private String ans;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void PostMagicAnswerShouldReturnAnswer() throws Exception {

        Answer inputAnswer = new Answer();

        inputAnswer.setAnswer(ans);
        inputAnswer.setQuestion("");
        inputAnswer.setId(idCounter++);

        String inputJson = objectMapper.writeValueAsString(inputAnswer);

        Answer OutputAnswer = new Answer();

        OutputAnswer.setAnswer(ans);
        OutputAnswer.setQuestion("");
        OutputAnswer.setId(idCounter++);

        String outputAns = objectMapper.writeValueAsString(OutputAnswer);

        mockMvc.perform(
                        post("/magic")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void PostMagicAnswerShouldReturnAnswerGivenQuestion() throws Exception {

        Answer inputAnswer = new Answer();

        inputAnswer.setAnswer(ans);
        inputAnswer.setQuestion("will I be happy");
        inputAnswer.setId(idCounter++);

        String inputJson = objectMapper.writeValueAsString(inputAnswer);

        Answer OutputAnswer = new Answer();

        OutputAnswer.setAnswer(ans);
        OutputAnswer.setQuestion("will I be happy");
        OutputAnswer.setId(idCounter++);

        String outputAns = objectMapper.writeValueAsString(OutputAnswer);

        mockMvc.perform(
                        post("/magic/will I be happy")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
