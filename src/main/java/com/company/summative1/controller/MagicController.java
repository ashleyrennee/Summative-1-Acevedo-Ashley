package com.company.summative1.controller;

import com.company.summative1.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

import java.util.Arrays;
import java.util.List;

// Magic 8 Ball controller
@RestController
public class MagicController {
    private List<Answer> possibleAnswers;
    public static int idCounter = 0;
     public MagicController(){
         Answer ans1 = new Answer(idCounter++,"It is certain.");
         Answer ans2 = new Answer(idCounter++,"It is decidedly so.");
         Answer ans3 = new Answer(idCounter++, "Without a doubt.");
         Answer ans4 = new Answer(idCounter++,"Yes, definitely.");
         Answer ans5 = new Answer(idCounter++,"You may rely on it.");
         Answer ans6 = new Answer(idCounter++,"As I see it, yes.");
         Answer ans7 = new Answer(idCounter++, "Most likely.");
         Answer ans8 = new Answer(idCounter++, "Outlook good.");
         Answer ans9 = new Answer(idCounter++,"Yes.");
         Answer ans10 = new Answer(idCounter++,"Signs point to yes.");
         Answer ans11 = new Answer(idCounter++, "Reply hazy, try again.");
         Answer ans12 = new Answer(idCounter++,  "Ask again later.");
         Answer ans13 = new Answer(idCounter++,"Better not tell you now.");
         Answer ans14 = new Answer(idCounter++, "Better not tell you now.");
         Answer ans15 = new Answer(idCounter++,"Cannot predict now.");
         Answer ans16 = new Answer(idCounter++,"Concentrate and ask again.");
         Answer ans17 = new Answer(idCounter++,"Don't count on it.");
         Answer ans18 = new Answer(idCounter++, "My reply is no.");
         possibleAnswers = Arrays.asList(ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,ans10,ans11,ans12,ans13,ans14,ans15,ans16,ans17,ans18);
     }
    @RequestMapping(value = "/magic", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public  Answer getMagicAnswer() {
        Random random = new Random();
        Answer answer = possibleAnswers.get(random.nextInt(possibleAnswers.size()));
        answer.setQuestion("");
        return answer;
    }

    @RequestMapping(value = "/magic/{ques}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public  Answer getMagicAnswer(@PathVariable String ques) {
        Random random = new Random();
        Answer answer = possibleAnswers.get(random.nextInt(possibleAnswers.size()));
        answer.setQuestion(ques);
        return answer;
    }

}
