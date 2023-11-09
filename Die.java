/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Die' class is one which will 
* simulates a single die in the game Yahtzee
*/

import java.util.*;

public class Die{
    // establish variables
    private int value;
    private static final int SIDES = 6;
    private static Random r = new Random();

    /**
    * Constructor that creates a Die
    * 
    * No parameters
    */
    public Die(){
        this.value = (int)r.nextInt(SIDES) + 1;
    }

    /**
    * Constructor that creates a Die with a predetermined value
    * 
    * @param input , a predetermined value of a Die
    */
    public Die(int input){
        this.value = input;
    }

    /**
    * Method that changes the value on the die
    * to a random value between 1 and SIDES
    *
    * @return none
    */
    public void roll(){
        this.value = (int)r.nextInt(SIDES) + 1;
    }
    
    /**
    * Method that gets the value of Die
    *
    * @return value of Die
    */
    public int getValue(){
        return value;
    }
    
    /**
    * Method that returns a string containing
    * the value represented on the die
    */
    @Override
    public String toString(){
        return Integer.toString(this.value);
    }
}
