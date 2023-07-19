package com.company.summative1.controller;
import com.company.summative1.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    private List<Definition> words;
    public WordController(){
        Definition word1 = new Definition(12345, "Gobemouche", "a credulous person or showing too great a readiness to believe absurb things ");
        Definition word2 = new Definition(12346, "Girandole", "a branched support for candles or other lights, which either stands on a surface or projects from a wall ");
        Definition word3 = new Definition(12347, "Gerrymandering", "manipulate the boundaries of (an electoral constituency) so as to favour one party or class ");
        Definition word4 = new Definition(12348, "Aa", "basaltic lava forming very rough, jagged masses with a light frothy texture ");
        Definition word5 = new Definition(12349, "Flub", "botch or bungle (something) ");
        Definition word6 = new Definition(12365, "whimsical", "unusual in a playful or amusing way");
        Definition word7 = new Definition(12389, "abscond", "To abscond is to leave, flee, or escape a place in secret and go into hiding");
        Definition word8 = new Definition(2355, "prowess", "someone’s great ability, skill, or talent for something");
        Definition word9 = new Definition(12536, "embezzle", "help bring it about");
        Definition word10 = new Definition(23545, "facilitate", "a credulous person or showing too great a readiness to believe absurb things ");
        Definition word11 = new Definition(1543, "kludge", "haphazard or makeshift solution to a problem and especially to a computer or programming problem");
        words = Arrays.asList(word1, word2, word3, word4, word5,word6,word7,word8,word9,word10,word11 );
    }


    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public List<Definition> getAllWords() {
        return words;
    }

    @RequestMapping(value = "/word/{w}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Definition getWord(@PathVariable String w ){

        for (Definition word : words) {
            if (word.getWord().equalsIgnoreCase(w)) {
                return word;
            }
        }
        return null;

    }
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public Definition getWordOfTheDay() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
}


