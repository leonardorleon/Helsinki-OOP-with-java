/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class MindfulDictionary {

    private Map<String, String> WordsAndTranslations = new HashMap<String, String>();
    private Map<String, String> WordsAndTranslationsReverse = new HashMap<String, String>();
    private String filePath;
    
    public MindfulDictionary() {
    }

    public MindfulDictionary(String file){
        filePath = file;
    }
    
    //method to take words and translations from a file so they can be used by the dictionary
    public boolean load() {
        try {
            Scanner reader = new Scanner(new File(filePath));
            while (reader.hasNextLine()) {
                String[] addToDictionary = reader.nextLine().split(":");     //read a line and split the word and translation separated by ":"
                add(addToDictionary[0], addToDictionary[1]);        //add the word (stored in [0]) and the respective translation (stored in [1])
            }
            return true;        //return true if the file has been loaded successfully
        
        } catch (Exception e) {
            return false;       //return false if opening or reading the file does not work
        }
    }
    
    //method to store the words and translations from the dictionary into a file given as parameter to the calss constructor 
    public boolean save(){
        try {
            FileWriter writer = new FileWriter(filePath);       //open a new writer for the file given in the class constructor
            for (String word : WordsAndTranslations.keySet()){      //iterate through all the keys in the regular dictionary map
                String line = word + ":" + WordsAndTranslations.get(word);      //generate a line in the from "word:translation"
                String lineBreak = "\n";
                writer.write(line);     //store the line in the file
                writer.write(lineBreak);        //do a line break after each line.
            }
            writer.close();     //close the writer when done
            return true;        //return true if saving the dictionary to the file was successful
        } catch (Exception e) {
            return false;       //if the file can't be saved, return false
        }
    }

    public void add(String word, String translation) {
        if (!WordsAndTranslations.containsKey(word) && !WordsAndTranslationsReverse.containsKey(word)) {        //if the word is in either of the maps, then do nothing
            WordsAndTranslations.put(word, translation);        //first add the word in the standard map 
            WordsAndTranslationsReverse.put(translation, word);     //then also add it to the reverse map
        }
    }

    public String translate(String word) {
        if (WordsAndTranslations.containsKey(word)) {
            return WordsAndTranslations.get(word);      //if the key is in the standard map, return the translation
        } else if (WordsAndTranslationsReverse.containsKey(word)) {
            return WordsAndTranslationsReverse.get(word);       //if the key is in the reverse map, return the reverse of the translation
        } else {
            return null;        //if it is not in either of the maps, return null
        }
    }

    public void remove(String word) {
        if (WordsAndTranslations.containsKey(word)) {            //First case: word is a key in the standard dictionary map
            String reverseKey = WordsAndTranslations.get(word);     //Take the value corresponding to the key in the regular mapa and store it as the key for the reverse map
            WordsAndTranslations.remove(word);      //remove the word fromt he regular map
            WordsAndTranslationsReverse.remove(reverseKey);     //use the reverse key to remove the word from the reverse map

        } else if (WordsAndTranslationsReverse.containsKey(word)) {      //Second case: word is key in the reverse dictonary map
            String regularKey = WordsAndTranslationsReverse.get(word);      //take the value from the reverse map, and store it as the key of the regular map
            WordsAndTranslationsReverse.remove(word);       //remove word from the reverse map
            WordsAndTranslations.remove(regularKey);        //use the regular key to remove from the regular map
        }
    }
}
