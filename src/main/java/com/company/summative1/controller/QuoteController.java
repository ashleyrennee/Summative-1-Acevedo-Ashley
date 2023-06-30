package com.company.summative1.controller;

import com.company.summative1.model.Quote;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@RestController
public class QuoteController {
    private static int idCounter = 1;
    private List<Quote> quotelist;
    public QuoteController(){
        Quote quote1 = new Quote(idCounter++,"Ashley","2 b or not 2 b");
        quotelist = Arrays.asList(quote1);
    }


}
