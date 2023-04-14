package com.kenzie.app;

import java.util.*;

public class Main {
    /* Java Fundamentals Capstone project: */

    public static void main(String[] args) {
        //Write main execution code here
        Scanner userInput = new Scanner(System.in);
        boolean keepPlaying = true;
        int score = 0;
        int counter = 0;
        int rounds = 1;
        ArrayList<Clues> listOfUsedClues = new ArrayList<>();
        //Program Below
        try {
            do {
                System.out.println("WELCOME TO TRIVIA NIGHT!");
                System.out.println("*****************************");
                do {
                    Clues randomClue = CluesDTO.randomClueGET();
                    if (!(listOfUsedClues.contains(randomClue))) {
                        listOfUsedClues.add(randomClue);
                        System.out.println("ROUND: " + rounds);
                        System.out.println(CluesDTO.randomQuestionDisplay(randomClue));
                        String userResponse = userInput.nextLine();
                        if (userResponse.equalsIgnoreCase(randomClue.getAnswer())) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("The Correct Answer is " + randomClue.getAnswer());
                        }
                        counter++;
                        rounds++;
                        System.out.println("Your Current Score is: " + score + "/10\n******************************");
                    } else {
                        break;
                    }
                } while (counter < 10);
                System.out.println("Here's How You Did");
                if (score >= 8) {
                    System.out.println("Your Score is " + score + "/10! Good Job!");
                }
                if (score >= 4 && score < 8) {
                    System.out.println("Your Score is " + score + "/10! You might want to try again.");
                } else {
                    System.out.println("Your Score is " + score + "/10! You should try again.");
                }
                System.out.println("Do You Want To Try Again? Y or N");
                String playAgain = userInput.nextLine();
                if (playAgain.equalsIgnoreCase("yes")) {
                    keepPlaying = true;
                    counter = 0;
                    score = 0;
                    rounds = 1;
                }
                if (playAgain.equalsIgnoreCase("y")) {
                    keepPlaying = true;
                    counter = 0;
                    score = 0;
                    rounds = 1;
                } else {
                    keepPlaying = false;
                }
            } while (keepPlaying);
        }
        catch (Exception e){
            System.out.println("Something Went Wrong. Try Again.");}
    }
}

