/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'SmallStraight' class is a class simulates
* simulates and evaluates filling 
* the Small Straight category in Yahtzee
*/

public class SmallStraight extends Category{
    /**
    * Default Constructor which creates an 
    * instance of "SmallStraight" for Yahtzee
    *
    * No parameters
    */
    public SmallStraight(){
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
        int[] diceCount = new int[6];
        int consecutive = 0;
        for(int i = 0; i < d.getNumDice(); i++){
            Die current = d.getDie(i);
            diceCount[current.getValue() - 1]++;
        }
        for(int i = 0; i < 6; i ++){
            if(diceCount[i] > 0){
                consecutive ++;
            }
            else{
                consecutive = 0;
            }
            if(consecutive >= 4){
                return 30;
            }
        }
        return 0;
    }
}