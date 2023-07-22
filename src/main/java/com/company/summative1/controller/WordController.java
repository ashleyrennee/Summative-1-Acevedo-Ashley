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
    private static int idCounter = 0;
    public WordController(){
        Definition word1 = new Definition(idCounter++, "Gobemouche", "a credulous person or showing too great a readiness to believe absurb things ");
        Definition word2 = new Definition(idCounter++, "Girandole", "a branched support for candles or other lights, which either stands on a surface or projects from a wall ");
        Definition word3 = new Definition(idCounter++, "Gerrymandering", "manipulate the boundaries of (an electoral constituency) so as to favour one party or class ");
        Definition word4 = new Definition(idCounter++, "Aa", "basaltic lava forming very rough, jagged masses with a light frothy texture ");
        Definition word5 = new Definition(idCounter++, "Flub", "botch or bungle (something) ");
        Definition word6 = new Definition(idCounter++, "whimsical", "unusual in a playful or amusing way");
        Definition word7 = new Definition(idCounter++, "abscond", "To abscond is to leave, flee, or escape a place in secret and go into hiding");
        Definition word8 = new Definition(idCounter++, "prowess", "someone’s great ability, skill, or talent for something");
        Definition word9 = new Definition(idCounter++, "embezzle", "help bring it about");
        Definition word10 = new Definition(idCounter++, "facilitate", "a credulous person or showing too great a readiness to believe absurb things ");
        Definition word11 = new Definition(idCounter++, "kludge", "haphazard or makeshift solution to a problem and especially to a computer or programming problem");
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


