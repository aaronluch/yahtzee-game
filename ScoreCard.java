/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'ScoreCard' class is a class that
* creates and shows the collection of
* categories and scores as well as totals
*/

import java.util.*;

public class ScoreCard{
    // establish variables
    private ArrayList<Category> scorecard;
    private int yahtzeeBonus;
    private static final int NUM_CATS = 13;

    /**
    * Default Constructor which creates a new
    * ScoreCard that holds all Category objects
    *
    * No parameters
    */
    public ScoreCard(){
        scorecard = new ArrayList<Category>(NUM_CATS);
        // create all Category objects to add to the ArrayList
        scorecard.add(new Ones());
        scorecard.add(new Twos());
        scorecard.add(new Threes());
        scorecard.add(new Fours());
        scorecard.add(new Fives());
        scorecard.add(new Sixes());
        scorecard.add(new ThreeOfAKind());
        scorecard.add(new FourOfAKind());
        scorecard.add(new FullHouse());
        scorecard.add(new SmallStraight());
        scorecard.add(new LargeStraight());
        scorecard.add(new FiveOfAKind()); // this is yahtzee
        scorecard.add(new Chance());
        yahtzeeBonus = 0;
    }

    /**
    * Method that uses a CategoryValue to get the
    * appropriate Category and score of that Category.
    *
    * Sets the appropriate scored element to true to mark it
    *
    * @param cv , Category Value to get appropriate Category
    * @param d , Dice object 
    * @return none
    */
    public void choose(CategoryValue cv, Dice d){
        for(Category c : scorecard){
            if((c.getClass().getSimpleName()).toString().toLowerCase().equals(cv.toString().
            replaceAll("\\s", "").toLowerCase()) && !c.getUsed()){
                c.addValue(d);
            }
        }
    }

    /**
    * Returns the score that would be achieved in this category 
    * with the provided Dice object.
    * 
    * @param cv , The category value to evaluate
    * @param d , The Dice object to evaluate
    * @return The score that would be achieved in this category
    */
    public int getEvaluation(CategoryValue cv, Dice d) {
        int index = cv.ordinal();
        Category c = scorecard.get(index);
        return c.evaluate(d);
    }

    /**
    * Checks if a Category has been used and returns
    * the truth value
    * 
    * @param cv , The category value to check
    * @return True if used, false otherwise
    */
    public boolean checkScored(CategoryValue cv) {
        int index = cv.ordinal();
        Category c = scorecard.get(index);
        return c.getUsed();
    }

    /**
    * Gives the current score for the specified Category
    * 
    * @param cv , The category value use score of
    * @return The current score for that category
    */
    public int getCategoryScore(CategoryValue cv) {
        int index = cv.ordinal();
        Category c = scorecard.get(index);
        return c.getScore();
    }

    /**
    * Returns the total score for the top of the scorecard
    * 
    * No parameters
    * @return the total score for the top of the scorecard
    */
    public int scoreTop(){
        int top = 0;
        for(int i = 0; i < 5; i++){
            Category c = scorecard.get(i);
            if(c.getUsed()){
                top += c.getScore();
            }
        }
        if(top >= 63){
            top += 35;
        }
        return top;
    }

    /**
    * Returns the total score for the bottom of the scorecard
    * 
    * No parameters
    * @return the total score for the bottom of the scorecard
    */
    public int scoreBottom(){
         int bottom = 0;
         for(int i = 6; i < NUM_CATS; i++){
             Category c = scorecard.get(i);
             if(c.getUsed()){
                 bottom += c.getScore();
             }
         }
         return bottom;
    }
    
    /**
    * Returns the total score for the entire scorecard
    * 
    * No parameters
    * @return the total score
    */
    public int score(){
        return scoreTop() + scoreBottom();
    }

    /**
    * Method that returns a string that
    * will write out a full scorecard
    *
    * @return formatted ScoreCard output
    */
    @Override
    public String toString(){
        return String.format("Current Scorecard:\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n%16s %d\n",
                "Ones:", scorecard.get(0).getScore(),
                "Twos:", scorecard.get(1).getScore(),
                "Threes:", scorecard.get(2).getScore(),
                "Fours:", scorecard.get(3).getScore(),
                "Fives:", scorecard.get(4).getScore(),
                "Sixes:", scorecard.get(5).getScore(),
                "Three of a Kind:", scorecard.get(6).getScore(),
                "Four of a Kind:", scorecard.get(7).getScore(),
                "Full House:", scorecard.get(8).getScore(),
                "Small Straight:", scorecard.get(9).getScore(),
                "Large Straight:", scorecard.get(10).getScore(),
                "Yahtzee:", scorecard.get(11).getScore(),
                "Chance:", scorecard.get(12).getScore(),
                "Upper Total:", scoreTop(),
                "Lower Total:", scoreBottom(),
                "Total:", score());
    }   

    /**
    * Method that returns a string that
    * will write out a full scorecard
    *
    * @return ScoreCard output for scoring method
    */
    public String toStringScores(){
        String[] categories = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", 
                               "Three of a Kind", "Four of a Kind", "Full House", 
                               "Small Straight", "Large Straight", "Yahtzee", "Chance"};
        String output = "";
        System.out.println("\n");
        for (int i = 0; i < categories.length; i++){
            output += String.format("%d: %s, %d points\n", i + 1, categories[i], scorecard.get(i).getScore());
        }
        return output;
    }
}
