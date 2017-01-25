/***************************************************************
* file: ScoreManager.java
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
* purpose: Add and sort Score Objects into an ArrayList into a text file.
*
****************************************************************/

package highscore;

import java.util.*;
import java.io.*;


public class ScoreManager {
    
    private ArrayList<Score> highscores;
    
    private static final String HIGHSCORE_FILE = "highscores.txt";
    
    // Constructor for ScoreManager
    public ScoreManager() {
        highscores = new ArrayList<>();
    }
    
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    // method: getScores
    //purpose: retreive highscores ArrayList after sorting
    public ArrayList<Score> getScores() {
        loadScores();
        sort();
        return highscores;
        
    }
    
    // method: sort
    //purpose: sort highscores ArrayList based on score value
    public void sort() {
        ScoreCompare comparator = new ScoreCompare();
        Collections.sort(highscores,comparator);
    }
    
    // method: addScore
    // purpose: adds score object to ArrayList<Score> highscores
    public void addScore(String name, int score) {
        loadScores();
        highscores.add(new Score(name, score));
        updateScores();
    }
    
    // method: loadScores
    //purpose: loads the arraylist in the HIGHSCORE_FILE  and will put it into
    //         the highscore ArrayList
    @SuppressWarnings("unchecked")
    public void loadScores() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            highscores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input/Output ERROR: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found ERROR: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Input/Output ERROR: " + e.getMessage());
            }
        }
    }
    
    // method: updateScores
    //purpose: writes highscore ArrayList<Score> to the file
    @SuppressWarnings("unchecked")
    public void updateScores() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(highscores);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found ERROR: " + e.getMessage() 
                    + ", the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("Input/Output ERROR: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Input/Output ERROR: " + e.getMessage());
            }
        }
    }
    
    // method: toString
    //purpose: return string of all scores and respective names in descending order
    @Override
    public String toString() {
        
        String highscoreString = "";
	final int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int size;
        size = scores.size();
        
        if (size > max) {
            size = max;
        }
        while (i < size) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t" 
                    + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }
}
