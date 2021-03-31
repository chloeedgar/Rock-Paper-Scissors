/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chloe.RockPaperScissorsAssessment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class RockPaperScissors {
    public static void main (String[] args){ 
        //Declaring variables
        int userChoice=0; 
        boolean play = true;
        boolean userChoiceValid = true;
        String[]validChoices = {"rock","paper","scissors"};
        
        //Declaring scanner and random number generator for later use
        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();
        
        //While loop that loops as long as the player wants to play i.e. play is set to true
        while (play=true){
            //Declaring varibles in while loop to ensure scores are wiped before starting a new game
            int computerWins = 0;
            int userWins = 0;
            int ties = 0;
            
            
            //User asked how many rounds they want to play & string is converted to number
            System.out.println("How many rounds do you want to play? Choose a number in the range 1-10.");
            int noOfRounds = Integer.parseInt(userInput.nextLine());

            //Error message is printed if the no of rounds is within the allowed range of 1-10
            if (noOfRounds>10 || noOfRounds<1) {
                System.out.println("Invalid number of rounds. Your number must be in the range 1-10");
            } else {
                //for loop to loop for the no of rounds specified by the user
                for (int i=1; i <= noOfRounds; i++) {
                    //while loop to loop whilst the user choice is valid i.e. it is either rock, paper or scissors
                    while (userChoiceValid=true){
                        System.out.println("What would you like to play? rock, paper or scissors?");
                        String stringUserChoice = userInput.nextLine();
                        
                        //the user's choice is converted to a number based on rock=1, paper=2, scissors=3
                        if (isChoiceValid(stringUserChoice,validChoices)==true){
                            userChoice = convertUserChoiceToNumber(stringUserChoice);
                            if (userChoice == 0){
                                System.out.println("Error");
                            }
                            break;
                        } else {
                            System.out.println("Invalid input. Please only input rock, paper or scissors.");
                            userChoiceValid = false;
                        }
                    }
                    
                    //Generate random number between 1 & 3 for the computers choice. .nextInt((range)-min)
                    int computerChoice = randomizer.nextInt((3+1)-1)+1;

                    //Compare the computers and user's choice to determine who wins
                    //if user's and computer's choice are the same, it's a tie:
                    switch (compareChoices(userChoice, computerChoice)) {
                        case "tie":
                            ties++;
                            break;
                        case "userWins":
                            userWins++;
                            break;
                        case "computerWins":
                            computerWins++;
                            break;
                        default:
                            System.out.println("Error");
                            break;
                    }

                    //if we are on the last round, do not print the end result to avoid it being repeated (not in flowchart)
                    if (i==noOfRounds){
                        //do nothing
                    } else {
                        System.out.println("The result of this round is: "+ties+" ties, "+userWins+" user wins, "+computerWins+" computer wins");
                    }
                }

                System.out.println("The overall results are:  ties: "+ties+"  |  user wins: "+userWins+" |  computer wins: "+computerWins);

                //To find who won overall, the computer & user wins are compared
                if (userWins > computerWins) {
                    System.out.println("The overall winner is the user");
                } else if (userWins == computerWins) {
                    System.out.println("Overall, user and computer tied");
                } else {
                    System.out.println("The overall winner is the computer");
                }

                //User is asked if they want to play again. Anything other than "y" stops the game.
                System.out.println("Do you want to play again? (y/n) ");
                String playAgain = userInput.nextLine();
                if (playAgain.equals("y")){
                    play = true;
                } else {
                    System.out.println("Thanks for playing!");
                    play = false;
                    break;
                }
            }
        }
    }
        
    public static boolean isChoiceValid(String stringUserChoice, String[]validChoices) {
        /**
         *This method compares checks if the users choice is valid by comparing it to an array of strings. 
         */
        for (String validChoice : validChoices) {
            if (validChoice.equals(stringUserChoice)) {
                return true;
            }
        }
        return false;
    }
    
    
    public static String compareChoices(int userChoice, int computerChoice) {
        /**
         *This method compares the user's choice with the computer's choice and returns who won/tie 
         */
        if (userChoice==computerChoice){
            return "tie";
        }
            //if user=rock, computer=paper, computer wins:
        else if (userChoice==1 && computerChoice==2) {
            return "computerWins";
        }
        //if user=rock, computer=scissors, user wins:
        else if (userChoice==1 && computerChoice==3) {
            return "userWins";
        }
        //if user=paper, computer=rock, user wins:
        else if (userChoice==2 && computerChoice==1 ){
            return "userWins";
        }
        //if user=paper, computer=scissors, computer wins:
        else if (userChoice==2 && computerChoice==3){
            return "computerWins";
        }
        //if user=scissors, computer=rock, computer wins:
        else if (userChoice==3 && computerChoice==1) {
            return "computerWins";
        }
        //if user=scissors, computer=paper, user wins:
        else if (userChoice==3 && computerChoice==2) {
            return "userWins";
        }
        return null;
    }

    public static int convertUserChoiceToNumber(String stringUserChoice) {
        /**
         *This method converts the users choice to a number
         */
        switch (stringUserChoice) {
            case "rock":
                return 1;
            case "paper":
                return 2;
            case "scissors":
                return 3;
            default:
                return 0;
        }
    }
}