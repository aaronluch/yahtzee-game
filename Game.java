/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Game' class is a class that
* prompts the user for inputs in the Game
*/

import java.util.*;

public class Game{
    private ScoreCard player1 = new ScoreCard();
    private ScoreCard player2 = new ScoreCard();
    private ScoreCard player1FirstTurn = new ScoreCard();
    private DiceRoll diceRoll = new DiceRoll();
    private int rollsLeft;
    private int player1Turns = 0;
    private int player2Turns = 0;
    Scanner input = new Scanner(System.in);
    CategoryValue category = null;
    boolean player1Turn = true;
    boolean reRoll = true;
    int flag = 0;
    boolean scoreAgain = true;
    ScoreCard currentPlayerScorecard = player1;
    ScoreCard otherPlayerScorecard = player2;
    String currentPlayerName = "Player 1";
    String otherPlayerName = "Player 2";
    ArrayList<Integer> savedDice = new ArrayList<Integer>();    // creates ArrayList for savedDice

    /** 
    * Constructor that creates the objects for the Game class
    *
    * no parameters
    * @return none
    */
    public Game(){
        player1 = new ScoreCard();
        player2 = new ScoreCard();
        diceRoll = new DiceRoll();
        rollsLeft = 3;
    }

    /** 
    * Method that checks if a user wants to save
    * a selected amount of Dice
    *
    * @param response , the inputted response taken by the scanner
    * @return none
    */
    public void saveDice(String response){
        try{
            List<String> responseList = new ArrayList<>(Arrays.asList(response.substring(1, response.length() - 1).split(" ")));
            for(int i = 0; i < responseList.size(); i++){
                String current = responseList.get(i).replaceAll("\\s", ",");
                responseList.set(i, current);
            }
    
            ArrayList<Integer> toRemove = new ArrayList<>(); // creates ArrayList with integer values to remove from Dice Array
    
            /**
            * Iterates to add saved dice from input to new saved ArrayList
            */
            for(int s = 0; s <= responseList.size() - 1; s++){
                int index = Integer.parseInt(responseList.get(s)) - 1;
                if(index >= 0 && index < diceRoll.getNumDice()){
                    Die currentDie = diceRoll.getDie(index);
                    int toAdd = currentDie.getValue();
                    savedDice.add(toAdd);
                    toRemove.add(index);
                } 
                else{
                    throw new IllegalArgumentException("Invalid index: " + index);
                }
            }
            // to remove dice in the Dice ArrayList afterwards
            for (int i = toRemove.size() - 1; i >= 0; i--){
                diceRoll.removeDie(toRemove.get(i));
            }
            /**
            * Re-prints the toString of each new ArrayList
            */
            System.out.println("Dice to reroll:");
            System.out.println(diceRoll.toString());
            System.out.println("Dice to save:");
            for(int s = 0; s < savedDice.size(); s++){
                System.out.println((s + 1) + ": value " + savedDice.get(s));
            }
        } 
        catch(Exception e){
            System.out.println("Error saving dice. " +
            "Please save dice with [ ] filled with index values separated by spaces");
        }
    }

    /** 
    * Method that rolls the Dice to reroll
    *
    * @param response , the inputted response taken by the scanner
    * @return none
    */
    public void roll(String response){
        //if(rollsLeft > 0){
            if(rollsLeft == 1){
                System.out.println("You cannot roll again.");
            }
            else if(rollsLeft != 0){
                rollsLeft--;
                System.out.println(currentPlayerScorecard.toString());
                diceRoll.toss();
                System.out.println("Dice to reroll:");
                System.out.println(diceRoll.toString());
                System.out.println("Dice to save:");
                for(int s = 0; s < savedDice.size(); s++){
                    System.out.println((s + 1) + ": value " + savedDice.get(s));
                }
           // }
        }
    }

    /** 
    * Method that scores all of the dice after the final roll
    *
    * @param response , the inputted response taken by the scanner
    * @return none
    */
    public void score(String response){
        if(scoreAgain){    
            for(int t = 0; t < savedDice.size(); t++){
                Die newDie = new Die(savedDice.get(t));
                diceRoll.addDie(newDie);
            }
        }
        System.out.println("\nFinal roll: ");
        for(int i = 0; i < diceRoll.getNumDice(); i++){
            Die currentDie = diceRoll.getDie(i);
            int toAdd = currentDie.getValue();
            System.out.println(i+1+": value " + toAdd);
        }
    
        if(flag != 1){
            player1FirstTurn = currentPlayerScorecard;
        }
        int categoryNum = -1;
        do{
            System.out.print("Select a category that you have not scored in yet:");
            System.out.println(currentPlayerScorecard.toStringScores());
            //scoreAgain = false; 
            try{
                categoryNum = input.nextInt() - 1;
                input.nextLine();
                //scoreAgain = false; 
            } 
            catch(InputMismatchException e){
                System.out.println("Invalid input, please enter a number.");
                input.nextLine();
                //scoreAgain = false; 
            } 
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Index out of bounds, please enter a valid index.");
                input.nextLine();
                //scoreAgain = false; 
            }
        } 

        while(categoryNum < 0 || categoryNum >= CategoryValue.values().length);
        CategoryValue category = CategoryValue.values()[categoryNum];
        if(!currentPlayerScorecard.checkScored(category)){
            int score = currentPlayerScorecard.getEvaluation(category, diceRoll);
            if(score >= 0){     // allow score of 0
                if(flag != 1){
                    player1FirstTurn.choose(category, diceRoll);
                }
                else{
                    currentPlayerScorecard.choose(category, diceRoll);
                }
                System.out.println("You scored " + score + " points in " + category.toString());
                reRoll = false;
            } 
            else{
                System.out.println("Cannot score for this category, choose another.");
            } 
        } 
        else{
            System.out.println("Category already scored, choose another.");
        }  
        rollsLeft = 3;
        //flag = 1;
    }
    
    /** 
    * Method that switches the player's turn after scoring
    *
    * no parameters
    * @return none
    */
    public void switchTurn(){
        // switch to other player's turn
        ScoreCard temp = new ScoreCard();
        if(player1Turn){
            temp = currentPlayerScorecard;
            currentPlayerScorecard = player2;
            otherPlayerScorecard = temp;
            currentPlayerName = "Player 2";
            otherPlayerName = "Player 1";
            player1Turn = false;
        } 
        else{
            temp = currentPlayerScorecard;
            currentPlayerScorecard = player1;
            otherPlayerScorecard = temp;
            currentPlayerName = "Player 1";
            otherPlayerName = "Player 2";
            player1Turn = true;
        }
        System.out.println("\n\n******************************************************\n\n");
    }

    /** 
    * Method that returns that a user's input was inavlid
    *
    * @param testInput , the truth value of valid user input
    * @return invalid / valid message
    */
    public String getResponseMessage(boolean testInput){
        if(!testInput){
            String output = ("Please enter a valid die number, roll, or score");
            return output;
        }
        else{
            String initialValidiation = ("Good!");
            return initialValidiation; 
        }
    }

    /** 
    * Method that returns that a user's input truth value
    *
    * @param response , user inputted response
    * @return truth value of response
    */
    public boolean validResponse(String response){
        if((response.startsWith("[") && response.endsWith("]")) || (response.equals("roll")) || (response.equals("score"))){
            return true; 
        }
        else if(!(response.startsWith("[") && response.endsWith("]")) && !(response.equals("roll")) && !(response.equals("score"))){
            return false;
        }
        else{
            return true;
        }
    }

    /** 
    * Method that prints the banner
    *
    * no parameters
    */
    public void printBanner(){
        System.out.println("*******************************************************");
        System.out.println("WELCOME TO YAHTZEE");
        System.out.println("*******************************************************");
    }

    /** 
    * Method that starts a user's turn
    *
    * no parameters
    */
    public void startTurn(){
        /**
        * Prints initial scorecard for current player
        */
        System.out.println(currentPlayerName + ":");
        System.out.println(currentPlayerScorecard.toString());
        
        /**
        * Increments how many turns each player has played
        */
        if(currentPlayerName.equals("Player 1")){
            player1Turns += 1;
        }
        else{
            player2Turns += 1;
        }

        /**
        * Tosses Dice and toString's the roll for initial roll
        */
        diceRoll.toss();
        System.out.println("Dice to reroll: ");
        System.out.println(diceRoll.toString());
    }

    /** 
    * Method that plays the game
    *
    * no parameters
    */
    public void play(){
        printBanner(); // prints banner
        while(player1Turns != 13 || player2Turns != 13){
            /**
            * Invokes inital steps method
            *
            * Sets up beginning steps of the game
            */
            startTurn();

            /**
            * Creates a large while loop to continually check
            * if the player has rolls left and or if they reroll
            */
            System.out.print("Save dice with [ ] filled with index values separated by spaces\n"
                            + "'roll' to reroll, 'score' to score:\n"); 

            while(rollsLeft > 0 && reRoll){
                String response = input.nextLine().toLowerCase(); // user input
                
                /**
                * Invokes validation method
                *
                * Checks if the user's subsequent inputs are valid
                */
                boolean testInput = validResponse(response);
                if(testInput){
                    /**
                    * Invokes saveDice method
                    * 
                    * Saves the inputted response dice
                    */
                    if(response.startsWith("[") && response.endsWith("]")){
                        saveDice(response);
                        System.out.print("Save dice with [ ] filled with index values separated by spaces\n"
                            + "'roll' to reroll, 'score' to score:\n"); 
                    }

                    /**
                    * Invokes roll method
                    * 
                    * Rolls all of the remaining dice under: 
                    * Dice to Reroll
                    */
                    if(response.equals("roll")){
                        roll(response);
                        System.out.print("Save dice with [ ] filled with index values separated by spaces\n"
                            + "'roll' to reroll, 'score' to score:\n"); 
                    }
                    
                    /**
                    * Invokes score method
                    * 
                    * Scores the desired category from user input
                    */
                    if(response.equals("score")){
                        score(response);
                    }
                }
                if(!testInput){
                    String responseMessage = getResponseMessage(testInput);
                    System.out.println(responseMessage);
                }
            }
            if(player1Turn){                 // needed to retain the first turn of
                player1 = player1FirstTurn;  // player 1 due to a bug; just an extra condition
                flag = 1;
            }
            switchTurn(); // calls to switch turns
            reRoll = true; // allows for next user to have reRolls again
            savedDice.clear(); // clears savedDice array
        }
        System.out.println("\nFinal Score for Player 1: " + player1.score());
        System.out.println("Final Score for Player 2: " + player2.score());
    }
}
