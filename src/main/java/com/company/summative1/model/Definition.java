package com.company.summative1.model;

public class Definition {

    int ID;
    String word;
    String definition;

    public Definition(int ID, String word, String definition){
        this.ID = ID;
        this.word= word;
        this.definition = definition;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}

