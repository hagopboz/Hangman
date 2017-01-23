/***************************************************************
* file: Answer.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* 
* Class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1.1
* date last modified: 1/22/2017
*
* purpose: Answer class used to generate a random answer for the
*          color game and to compare to the user's answers.
*
****************************************************************/

package other;

import java.util.Random;

public class Answer {
    
    private String color;
    private String text;
    
    // method: Asnwer
    // purpose: constructor for the class, randomly selects a
    //          color and text from the given string array
    public Answer (String[] colorList) {
        Random rand = new Random();
        this.color = colorList[rand.nextInt(colorList.length)];
        this.text = colorList[rand.nextInt(colorList.length)];
    }
        
    // method: getColor
    // purpose: gets the color attribute of the answer
    public String getColor() {
        return color;
    }
    
    // method: getText
    // purpose: gets the text attribute of the answer
    public String getText() {
        return text;
    }
}
