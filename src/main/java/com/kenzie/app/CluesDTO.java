package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;


public  class CluesDTO {
    private final static String LIST_OF_QUESTIONS_ENDPOINT = "https://jservice.kenzie.academy/api/clues";
    private final static String Randomurl = "https://jservice.kenzie.academy/api/random-clue";

    @JsonProperty("clues")
    private List<Clues> clues;
    private Clues clue;
    private Category category;

    public String getCategory() {
        return this.category.getId() + this.category.getTitle() + this.category.getCanon();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Clues getClue() {
        return clue;
    }

    public void setClue(Clues clue) {
        this.clue = clue;
    }

    public List<Clues> getClues () {
            return clues;
        }

        public void setClues (List <Clues> clues) {
        this.clues = clues;
        }
    public static Clues randomClueGET() throws IOException {
        String jsonString = CustomHttpClient.sendGET(Randomurl);
        ObjectMapper obj = new ObjectMapper();
        Clues clueObject = obj.readValue(jsonString, Clues.class);
        return clueObject;
    }
    public static String randomQuestionDisplay(Clues clue){
        return "~Category~" + clue.getCategoryString() + "\nQuestion: " + clue.getQuestion();
        }
    }


