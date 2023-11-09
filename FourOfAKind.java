/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'FourOfAKind' class is a class simulates
* simulates and evaluates filling 
* the Four Of A Kind category in Yahtzee
*/

public class FourOfAKind extends Category{
    /**
    * Default Constructor which creates an 
    * instance of "FourOfAKind" for Yahtzee
    *
    * No parameters
    */
    public FourOfAKind(){
        super();
    }

    /**
    * Method that takes in a Dice object and returns
    * the score representation for it's respective category.
    *
    * Loops through each possible die value (1-6) and counts 
    * the number of matching dice
    *
    * @param d , the Dice to evaluate
    * @return score for category
    */
    @Override
    public int evaluate(Dice d){
        int score = 0;
        int[] valueCounts = new int[6];
        boolean foundFourOfAKind = false;
    
        for(int i = 0; i < d.getNumDice(); i++){
            int value = d.getDie(i).getValue();
            valueCounts[value - 1]++;
        }
    
        int i = 0;
        while(i < 6 && !foundFourOfAKind){
            if(valueCounts[i] >= 4){
                score = 4 * (i + 1);
                foundFourOfAKind = true;
            }
            i++;
        }
    
        return score;
    }
}
