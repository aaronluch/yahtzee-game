/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'FourOfAKind' class is a class simulates
* simulates and evaluates filling 
* the Five Of A Kind category in Yahtzee
*/

public class FiveOfAKind extends Category{
    private boolean hasScoredYahtzee; // this is to check if the user has scored a Yahtzee before
    /**
    * Default Constructor which creates an 
    * instance of "FourOfAKind" for Yahtzee
    *
    * No parameters
    */
    public FiveOfAKind(){
        super();
        hasScoredYahtzee = false;
    }

    /**
    * Method that takes in a Dice object and returns
    * the score representation for it's respective category.
    * Also includes the ability to add a Yahtzee bonus.
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

        for(int i = 0; i < d.getNumDice(); i++){
            int value = d.getDie(i).getValue();
            valueCounts[value - 1]++;
            score += value;
        }

        boolean hasYahtzee = false;
        int i = 0;
        while(!hasYahtzee && i < 6){
            if(valueCounts[i] >= 5){
                hasYahtzee = true;
            }
            i++;
        }

        if (hasYahtzee){
            if(hasScoredYahtzee){
                score += 100;
            } 
            else{
                score = 50;
                hasScoredYahtzee = true;
            }
        } 
        else{
            score = 0;
        }
        return score;
    }
}

