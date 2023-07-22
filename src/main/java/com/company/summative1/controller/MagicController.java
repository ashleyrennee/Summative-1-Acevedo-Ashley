package com.company.summative1.controller;

import com.company.summative1.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Random;

import java.util.Arrays;
import java.util.List;

// Magic 8 Ball controller
@RestController
public class MagicController {
    private List<String> possibleAnswers;
    public static int idCounter = 0;
    MagicController(){
        possibleAnswers = Arrays.asList("It is certain.","It is decidedly so.","Yes, definitely.",
                "You may rely on it.","Outlook good.","Absolutely not.");
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody Answer answer) {
        Random random = new Random();
        String ans = possibleAnswers.get(random.nextInt(possibleAnswers.size()));
        answer.setId(idCounter++);
        answer.setQuestion("");
        answer.setAnswer(ans);
        return answer;
    }

    @RequestMapping(value = "/magic/{ques}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public  Answer createMagicAnswerQuestion(@RequestBody Answer answer,@PathVariable String ques) {
        Random random = new Random();
        String ans = possibleAnswers.get(random.nextInt(possibleAnswers.size()));
        answer.setId(idCounter++);
        answer.setQuestion(ques);
        answer.setAnswer(ans);
        return answer;
    }

}
