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
        Quote quote1 = new Quote(idCounter++,"Audre Lorde","My silences had not protected me.\n" +
                " Your silence will not protect you.");
        Quote quote2 = new Quote(idCounter++,"Angela Y. Davis","It is in collectivities that we find " +
                "reservoirs of hope and optimism.");
        Quote quote3 = new Quote(idCounter++,"Robin Wall Kimmerer","The land knows you even when you are lost");
        Quote quote4 = new Quote(idCounter++,"Bell Hooks","Love is an action, never simply a feeling");
        Quote quote5 = new Quote(idCounter++,"Carmen Maria Machado","We deserve to have our wrongdoing " +
                "represented as much as our heroism, because when we refuse wrongdoing as a possibility for a group of people, we refuse their humanity.");
        Quote quote6 = new Quote(idCounter++,"Carmen Maria Machado","Fear makes liars of us all");
        Quote quote7 = new Quote(idCounter++,"Stephen Graham Jones","We all become history at some point, right?");
        Quote quote8 = new Quote(idCounter++,"Elizabeth Acevedo","And I think about all the things we could be " +
                "if we were never told our bodies were not built for them.");
        Quote quote9 = new Quote(idCounter++,"Wally Lamb","But what are our stories if not the mirrors we hold up to our fears?");
        Quote quote10 = new Quote(idCounter++,"Bell Hooks","Being oppressed means the absence of choices");
        quotelist = Arrays.asList(quote1,quote2,quote3,quote4,quote5,quote6,quote7,quote8,quote9,quote10);
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getRandomQuote(){
        Random random = new Random();
        return quotelist.get(random.nextInt(quotelist.size()));
    }


}
