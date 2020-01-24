/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author leonardo
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnalysisOld {
    
    private List<String> lines;
    
    public AnalysisOld(File file) throws Exception{
        Scanner reader = new Scanner(file);
        lines = new ArrayList<String>();
        while (reader.hasNextLine()){
            lines.add(reader.nextLine());       //save the contents of the file onto an array list composed of lines
        }
    }
    
    //method to return the number of lines on the file
    public int lines(){
        int lineNumber = 0;
        for (String line : lines){
            lineNumber++;
        }
        
        return lineNumber;
    }
    
    //method to return the number of characters
    public int characters(){
        int charNumber = 0;
        
        for (String line : lines){      //go through each line  
            charNumber+= line.length();     //take the length of the file
            charNumber++;       //add a new character when a line ends, since a line break is a character
        }
        
        return charNumber;
    }
    
}
