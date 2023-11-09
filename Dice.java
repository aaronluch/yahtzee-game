/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'Dice' class is an initially
* empty container to add Die objects to
*/

import java.util.*;

public class Dice{
    // establish variables
    private ArrayList<Die> dice;
    private static final int DEF_CAP = 5;

    /**
    * Constructor that creates a new array list
    * with the capacity from DEF_CAP
    * 
    * No parameters
    */
    public Dice(){
        dice = new ArrayList<>(DEF_CAP);
    }

    /**
    * Constructor that creates a new array list
    * with the capacity from DEF_CAP
    * 
    * @param num , predefined capacity of dice ArrayList
    */
    public Dice(int num){
        dice = new ArrayList<>(num);
    }

    /**
    * Method that adds Die d to the end of the ArrayList
    *
    * @return none
    */
    public void addDie(Die d){
        dice.add(d);
    }

    /**
    * Method that gets the number of dice
    *
    * @return number of dice
    */
    public int getNumDice(){
        return dice.size();
    }

    /**
    * Method that gets the a specific die at the passed index
    *
    * @return die at specific index i
    */
    public Die getDie(int i){
        return dice.get(i);
    }

    /**
    * Method that removes a die at a specified index
    *
    * @return none
    */
    public void removeDie(int i){
        dice.remove(i);
    }

    /**
    * Method that counts the number of die in the ArrayList
    * that have the same value as specified
    *
    * @return number of die with specified value
    */
    public int count(int val){
        int count = 0;
        for(int i = 0; i < dice.size(); i++){
            if (dice.get(i).getValue() == val){
                count ++;
            }
        }
        return count;
    }

    /**
    * Method that returns the sum of the 
    * die values in the ArrayList
    *
    * @return sum of the die
    */
    public int sum(){
        int sum = 0;
        for(int i = 0; i < dice.size(); i ++){
            sum += dice.get(i).getValue();
        }
        return sum;
    }

    /**
    * Method that evaluates if one of the Die
    * in the ArrayList is the same as the specified value
    *
    * @return true / false based on the specified value
    */
    public boolean contains(int val){
        for(int i = 0; i < dice.size(); i ++){
            if (dice.get(i).getValue() == val){
                return true;
            }
        }
        return false;
    }

    /**
    * Method that returns a string containing
    * the each Die in the ArrayList, it's index, and value
    */
    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < dice.size(); i++){
            result += (i + 1) + ": value " + dice.get(i).getValue() + "\n";
        }
        return result;
    }

}
