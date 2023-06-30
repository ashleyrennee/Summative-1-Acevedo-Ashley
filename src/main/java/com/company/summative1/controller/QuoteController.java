package com.company.summative1.controller;

import com.company.summative1.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    private static int idCounter = 1;
    private List<Quote> quotelist;
    public QuoteController(){
        Quote quote1 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote2 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote3 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote4 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote5 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote6 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote7 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote8 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote9 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote10 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote11 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        Quote quote12 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        quotelist = Arrays.asList(quote1,quote2,quote3,quote4,quote5,quote6,quote7,quote8,quote9,quote10,quote11,quote12);
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getRandomQuote(){
        Random random = new Random();
        return quotelist.get(random.nextInt(quotelist.size()));
    }


}
