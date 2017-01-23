/***************************************************************
* file: ColorGame.java
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
* purpose: Provides methods used in the color game GUI          
*
****************************************************************/

package other;

public class ColorGame {
    
    private int score = 0;
    private Answer answer;
    private String userAnswer = ""; //idk if this is how we should do it
    private int rounds = 0; //max 5
    
    
    public void initialize (int score) {
        String[] colorList = {"red", "yellow", "green", "blue", "purple"};
        answer = new Answer (colorList);
    }
    
    public void addScore (int points) {
        score = score + points;
    }
    
    public boolean isCorrect (String userAnswer){
        return userAnswer.equals(answer.getColor());
    }
    
    public int getScore() {
        return score;
    }
    
    public void setUserAnswer (String userAnswer){
        this.userAnswer = userAnswer;
    }    
}

