/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Fours' class is a class simulates
* simulates and evaluates filling 
* the Fours category in Yahtzee
*/

public class Fours extends Category{
    /**
    * Default Constructor which creates an 
    * instance of "Fours" for Yahtzee
    *
    * No parameters
    */
    public Fours(){
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
            if (current.getValue() == 4){
                score += 4;
            }
        }
        return score;
    }
}
