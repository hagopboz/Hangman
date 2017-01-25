/***************************************************************
* file: Score.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* 
* Class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1.1
* date last modified: 1/23/2017
*
* purpose: Serializable Score object class to store user's name and score.
*
****************************************************************/
package highscore;

import java.io.Serializable;

/**
 * Serializable Score object class used to store user's name and totalScore
 */
public class Score implements Serializable {
       private int score;
       private String name;
       
       // Score constructor (name, score)
       public Score(String name, int score) {
           this.name = name;
           this.score = score;
       }
       
       // returns name of user
       public String getName() {
           return name;
       }
       // returns score
       public int getScore() {
           return score;
       }
       
       
}
