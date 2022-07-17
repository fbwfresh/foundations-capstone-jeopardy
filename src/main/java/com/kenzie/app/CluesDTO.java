package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Random;

public  class CluesDTO {


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

    final static String LIST_OF_QUESTIONS_ENDPOINT = "https://jservice.kenzie.academy/api/clues";
    final static String API_ENDPOINT = "https://jservice.kenzie.academy/";

    private final static String Randomurl = "https://jservice.kenzie.academy/api/random-clue";

    public Clues getClue() {
        return clue;
    }

    public void setClue(Clues clue) {
        this.clue = clue;
    }

    public static Clues randomClueGET() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(Randomurl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            String randomClue = httpResponse.body();
            ObjectMapper obj = new ObjectMapper();
            Clues clueObject = obj.readValue(randomClue, Clues.class);
            return clueObject;
    }
    public static String randomQuestionDisplay(Clues clue){

        return /*"ID:" + clue.getId() +*/"\n~Category~" + clue.getCategoryString() + "\nQuestion: " + clue.getQuestion();
    }



//    public static String askClue(){
//        Clues clue = new Clues();
//        Random random = new Random();
//      int randomNumber = random.nextInt(100);
//
//        return
//
//    }

        public List<Clues> getClues () {
            return clues;
        }

        public void setClues (List < Clues > clues) {
            this.clues = clues;
        }
    }


