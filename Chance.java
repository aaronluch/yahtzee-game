/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Chance' class is a class simulates
* simulates and evaluates filling 
* the Chance category in Yahtzee
*/

public class Chance extends Category{
    /**
    * Default Constructor which creates an 
    * instance of "Chance" for Yahtzee
    *
    * No parameters
    */
    public Chance(){
        super();
    }

    /**
    * Method that takes in a Dice object and returns
    * the score representation for it's respective category.
    *
    * @param d , the Dice to evaluate
    * @return score for category
    */
    @Override
    public int evaluate(Dice d){
        int sum = 0;
        for(int i = 0; i < d.getNumDice(); i++){
            Die current = d.getDie(i);
            sum += current.getValue();
        }
        return sum;
    }
}
