/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class Analysis {

    private File file;

    public Analysis(File file) {
        this.file = file;       //get the file and store it in an object variable
    }

    public String readFile() {
        Scanner reader;
        
        try {
            reader = new Scanner(file);
            String contents = "";
            
            while (reader.hasNextLine()){
                contents+= reader.nextLine();       //read a line and store it 
                contents+= "\n";        //add the symbol for a line break to separate each line
            }
            return contents;
        } catch(FileNotFoundException ex){
            return "";
        }
        
        
    }

    //method to return the number of lines
    public int lines() {
       String contents = readFile();
       return contents.split("\n").length;
    }

    //method to return the number of characters
    public int characters() {
        String contents = readFile();
        return contents.length();
    }

}
