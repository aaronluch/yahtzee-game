/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'ThreeOfAKind' class is a class simulates
* simulates and evaluates filling 
* the Three Of A Kind category in Yahtzee
*/

public class ThreeOfAKind extends Category{
    /**
    * Default Constructor which creates an 
    * instance of "ThreeOfAKind" for Yahtzee
    *
    * No parameters
    */
    public ThreeOfAKind(){
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
        int amount = 0;
        int score = 0;
        int newWinning = 0;
        int[] valueCounts = new int[6];

        for(int i = 0; i < d.getNumDice(); i++){
            int value = d.getDie(i).getValue();
            valueCounts[value - 1]++;
        }

        boolean found = false;
        int i = 0;
        while(!found && i < 6){
            if(valueCounts[i] >= 3){
                found = true;
                for(int j = 0; j < d.getNumDice(); j++){
                    if(d.getDie(j).getValue() == i + 1){
                        amount += 1;
                        score += d.getDie(j).getValue();
                    }
                }
            }
            i++;
        }
        if(amount > 3){
            newWinning = score / 4;
        }
        return (newWinning * 3);
    }
}