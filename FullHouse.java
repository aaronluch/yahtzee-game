/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'FullHouse' class is a class simulates
* simulates and evaluates filling 
* the Full House category in Yahtzee
*/

public class FullHouse extends Category{
    /**
    * Default Constructor which creates an 
    * instance of "FullHouse" for Yahtzee
    *
    * No parameters
    */
    public FullHouse(){
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
        int score = 0;
        boolean twoOfAKind = false;
        boolean threeOfAKind = false;

        for(int i = 1; i <= 6; i++){
            int count = 0;
            for(int k = 0; k < d.getNumDice(); k++){
                Die current = d.getDie(k);
                if(current.getValue() == i){
                    count++;
                }
            }
            if(count == 2){
                twoOfAKind = true;
            }
            else if(count == 3){
                threeOfAKind = true;
            }
            
        }
        if (twoOfAKind && threeOfAKind) {
            score = 25;
        }
        return score;
    }
}
