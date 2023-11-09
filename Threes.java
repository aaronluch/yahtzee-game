/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Threes' class is a class simulates
* simulates and evaluates filling 
* the Threes category in Yahtzee
*/

public class Threes extends Category{
    /**
    * Default Constructor which creates an 
    * instance of "Threes" for Yahtzee
    *
    * No parameters
    */
    public Threes(){
        super();
    }

    /**
    * Method that takes in a Dice object and returns
    * the score representation for it's respective category
    *
    * @param d , the Dice to evaluate
    * @return score for category
    */
    @Override
    public int evaluate(Dice d){
        int score = 0;
        for(int i = 0; i < d.getNumDice(); i++){
            Die current = d.getDie(i);
            if (current.getValue() == 3){
                score += 3;
            }
        }
        return score;
    }
}

