package com.company.summative1.model;

import java.util.Objects;

public class Definition {

    private int ID;
    private String word;
    private String definition;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return ID == that.ID && Objects.equals(word, that.word) && Objects.equals(definition, that.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, word, definition);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "ID=" + ID +
                ", word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}

