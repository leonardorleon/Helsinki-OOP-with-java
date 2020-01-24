
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leonardo
 */

public class Printer {

    private final File f;
    private final Scanner reader;
    private final ArrayList<String> contents; 

    public Printer(String fileName) throws Exception {
        this.f = new File(fileName);        //create the file with the given parameter as the path
        this.reader = new Scanner(f);       //feed the file to the scanner so it can read it's contents
        this.contents = new ArrayList<String>();
        
        while (reader.hasNextLine()) {
            String line = reader.nextLine();        //read the line from the file
            contents.add(line);     //store each line in an array list so we only have to read the file once
        }
    }

    //method to print the lines containing a certain word
    public void printLinesWhichContain(String word) {
        
        if (word.equals("")) {
            for (String line : contents){
                System.out.println(line);       //if the parameter given was an empty string, print the whole content
            }
        } else {
            for (String line : contents){
                if (line.contains(word)){
                    System.out.println(line);       //if the parameter was a particular word, print the lines that contain that word
                }
            }
        }

    }

}
