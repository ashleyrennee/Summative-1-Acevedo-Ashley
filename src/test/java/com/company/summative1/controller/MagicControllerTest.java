package com.company.summative1.controller;

import com.company.summative1.model.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MagicControllerTest {
    private MockMvc mockMvc;

    @Mock
    private MagicController magicController;

    @InjectMocks
    private MagicControllerTest magicControllerTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(magicController).build();
    }

    @Test
    void getMagicAnswer_ShouldReturnAnswer() throws Exception {
        Answer question = new Answer();
        question.setQuestion("Will it rain tomorrow?");

        when(magicController.getMagicAnswer(any(Answer.class))).thenReturn(question);

        mockMvc.perform(MockMvcRequestBuilders.post("/magic")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"question\": \"Will it rain tomorrow?\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.question").value("Will it rain tomorrow?"))
                .andExpect(jsonPath("$.answer").isString());
    }
}
