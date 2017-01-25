/***************************************************************
* file: ScoreCompare.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* 
* Class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1.1
* date last modified: 1/25/2017
*
* purpose: Used to compare and help sort ArrayList<Score> values based on score.
*
****************************************************************/
package highscore;

import java.util.Comparator;



public class ScoreCompare implements Comparator<Score> {
    public int compare(Score score1, Score score2) {
        
        int sc1 = score1.getScore();
        int sc2 = score2.getScore();
        
        if(sc1 > sc2) {
            return -1;
        } else if (sc1 < sc2) {
            return 1;
        } else {
            return 0;
        }
    }
}
