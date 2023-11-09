/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Ones' class is a class simulates
* simulates and evaluates filling 
* the Ones category in Yahtzee
*/

public class Ones extends Category{
    /**
    * Default Constructor which creates an
    * instance of "Ones" for Yahtzee
    * 
    * No parameters
    */
    public Ones(){
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
            if (current.getValue() == 1){
                score += 1;
            }
        }
        return score;
    }
}
