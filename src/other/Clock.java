/***************************************************************
* file: Clock.java
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
* purpose: Creates and works the clock function in the play screen
*
****************************************************************/

package other;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {

    // method: main
    // purpose: creates the date and time, then prints it out.
    public static void main(String[] args) {
       //getting current date and time using Date class
       DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       Date dateobj = new Date();
       System.out.println(df.format(dateobj));

    }
    
}
