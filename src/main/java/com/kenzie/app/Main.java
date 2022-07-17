package com.kenzie.app;

// import necessary libraries


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.*;

import java.sql.Time;

public class Main {
    final static String LIST_OF_QUESTIONS_ENDPOINT = "https://jservice.kenzie.academy/api/clues";
    final static String  API_ENDPOINT = "https://jservice.kenzie.academy/";
    final static String RANDOM_CLUE = "https://jservice.kenzie.academy/api/random-clue";

    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!

     */

    public static void main(String[] args) throws IOException, InterruptedException {
        //Write main execution code here
        ObjectMapper obj = new ObjectMapper();
        Scanner userInput = new Scanner(System.in);
        boolean keepPlaying = true;
        int score = 0;
        int counter = 0;
        int rounds = 1;
        ArrayList<Clues> listOfUsedClues = new ArrayList<>();
        //Program Below
        do {
            System.out.println("WELCOME TO TRIVIA NIGHT!");
            System.out.println("*****************************");
            do {

                Clues randomClue = CluesDTO.randomClueGET();
                if (!(listOfUsedClues.contains(randomClue))) {
                    listOfUsedClues.add(randomClue);
                    System.out.println("ROUND: " +rounds);
                    System.out.println(CluesDTO.randomQuestionDisplay(randomClue));
                    String userResponse = userInput.nextLine();
                    if (userResponse.equalsIgnoreCase(randomClue.getAnswer())) {
                        System.out.println("Correct!");
                        score++;
                        counter++;
                        rounds++;
                        System.out.println("Your Current Score is: " + score + "/10\n******************************");
                    } else {
                        System.out.println("The Correct Answer is " + randomClue.getAnswer());
                        counter++;
                        rounds++;
                        System.out.println("Your Current Score is: " + score + "/10\n******************************");
                    }
                } else {
                    break;
                }
            } while (counter < 10);
            System.out.println("Here's How You Did");
            if(score >= 8){
                System.out.println("Your Score is " + score + "/10! Good Job!");
            } if(score >= 4 && score < 8){
                System.out.println("Your Score is " + score + "/10! You might want to try again.");
            } else{
                System.out.println("Your Score is " + score +"/10! You should try again." );
            }
            System.out.println("Do You Want To Try Again? Y or N");
            String playAgain = userInput.nextLine();
            if(playAgain.equalsIgnoreCase("yes")){
                keepPlaying = true;
                counter = 0;
                score = 0;
                rounds = 1;
            }
            if(playAgain.equalsIgnoreCase("y")){
                keepPlaying = true;
                counter = 0;
                score = 0;
                rounds = 1;
            } else{
                keepPlaying = false;
            }
        }while(keepPlaying);
    }
}

