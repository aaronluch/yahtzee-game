/** @author Aaron Luciano
* CS 110 - Final Project
* 4/25/23
* The 'CategoryValue' class is an enumerated type-class 
* which will provide all the values for types of
* scoring method in the game Yahtzee
*/

public enum CategoryValue{
    /**
    A Collection of values. Each element in collection has a value and a name
    */
    ONES(0, "Ones"),
    TWOS(1, "Twos"),
    THREES(2, "Threes"),
    FOURS(3, "Fours"),
    FIVES(4, "Fives"),
    SIXES(5, "Sixes"),
    THREE_OF_A_KIND(6, "Three of a Kind"),
    FOUR_OF_A_KIND(7, "Four of a Kind"),
    FULL_HOUSE(8, "Full House"),
    SM_STRAIGHT(9, "Small Straight"),
    LG_STRAIGHT(10, "Large Straight"),
    YAHTZEE(11, "Yahtzee"),
    CHANCE(12, "Chance");

    // establish variables
    private final int value;
    private final String name;

    /**
    * Constructor that specifies that value and name
    * 
    * @param v , the value
    * @param n , the name
    */
    private CategoryValue(int v, String n){
        value = v;
        name = n;
    }

    /**
    * Method that gets the value of CategoryValue
    *
    * @return value of CategoryValue
    */
    public int getValue(){
        return value;
    }
    
    /**
    * Method that returns a String representation of CategoryValue
    *
    * @return name , the name of CategoryValue
    */
    @Override
    public String toString(){
        return name;
    }
}
