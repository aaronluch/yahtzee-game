/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'DiceRoll' class is a class which inherits
* from the Dice class and allows for simulated rolling
*/

public class DiceRoll extends Dice{
    // establish variables
    private static final int NUM_DIE = 5;

    /**
    * Constructor that fills the object
    * with static int NUM_DIE random objects
    * 
    * No parameters
    */
    public DiceRoll(){
        super(NUM_DIE);
        for (int i = 0; i < NUM_DIE; i++) {
            addDie(new Die());
        }
    }

    /**
    * Method which rolls each of the Die in the Dice ArrayList
    *
    * @return none
    */
    public void toss(){
        for (int i = 0; i < getNumDice(); i++) {
            getDie(i).roll();
        }
    }
}