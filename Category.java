/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Category' class is an abstract class
* for all categories on the scorecard
*/

public abstract class Category{
    // establish variables
    private int score;
    private boolean used;
    
    /**
    * An abstract method that will evaluate the Die in
    * the Dice object and return a score
    */
    public abstract int evaluate(Dice d);

    /**
    * Method which adds the value the Dice would 
    * produce to the score 
    *
    * @return none
    */
    public void addValue(Dice d){
        score = evaluate(d);
        used = true;
    }

    /**
    * Method that returns the current score 
    * for a respective category
    *
    * @return score for category
    */
    public int getScore(){
        return score;
    }

    /**
    * Method Returns value of used indicating 
    * if category has been used.
    *
    * @return if a category is used
    */
    public boolean getUsed(){
        return used;
    }
}
