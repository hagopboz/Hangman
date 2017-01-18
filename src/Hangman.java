/***************************************************************
* file: Hangman.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* 
* Class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1.0
* date last modified: 1/16/2017
*
* purpose: Driver for the entire Hangman game and starts it.
*
****************************************************************/

import gui.*;

public class Hangman {
    
    // method: main
    // purpose: starts the entire Hangman game
    public static void main(String[]args) throws InterruptedException {
        Thread.sleep(2500);
        new MenuGUI();
    }

}
