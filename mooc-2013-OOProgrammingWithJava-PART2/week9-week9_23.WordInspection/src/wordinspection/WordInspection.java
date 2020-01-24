/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class WordInspection {

    private File file;
    private List<String> contents;

    public WordInspection(File file) {
        this.file = file;
        this.contents = readFile();
    }

    //method to count the amount of words;
    public int wordCount() {
        List<String> content = readFile();
        return contents.size();
    }

    //method to find words containing z
    public List<String> wordsContainingZ() {
        List<String> zWords = new ArrayList<String>();      //create an arrayList for the z words
        for (String word : contents) {
            if (word.contains("z") || word.contains("Z")) {
                zWords.add(word);       //iterate through array and store z words into the array list created for them
            }
        }

        return zWords;
    }

    //method for words ending in l
    public List<String> wordsEndingInL() {
        List<String> wordsEndingInL = new ArrayList<String>();
        for (String word : contents) {
            if (word.endsWith("l") || word.endsWith("L")) {
                wordsEndingInL.add(word);       //store the word if it ends in l
            }
        }

        return wordsEndingInL;
    }

    //method to find palindromes (words that are the same backwards)
    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<String>();
        //let's go through each word and find their reverse, then compare to the original and if it's the same store it in the palindromes list
        for (String word : contents) {
            String reverseWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord += word.charAt(i);
            }
//            System.out.println(word);             //test line
//            System.out.println(reverseWord);      //test line
//            System.out.println("--------");       //test line

            //check for palindromes
            if (word.equals(reverseWord)) {
                palindromes.add(word);
            }
        }

        return palindromes;     //return the list
    }

    //method that finds words that contain all finnish vowels
    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWithAllVowels = new ArrayList<String>();
        wordsWithAllVowels.addAll(contents);
        String vowels = "aeiouyäö";     //these are the vowels we are looking for
        
        for (String word : contents) {                                          //let's look at each word
            for (int i = 0; i < vowels.length(); i++) {                         //iterate through each vowel
                String vowel = Character.toString(vowels.charAt(i));            //set current vowel to the iterating variable
                
                if (!word.contains(vowel)) {                                    //if the word does not contain the vowel, remove it from the list, otherwise move on to the next vowel.
                    wordsWithAllVowels.remove(word);
                }
//                System.out.println(vowel);      //test line

            }
//            System.out.println("-----------");      //test line

        }
        return wordsWithAllVowels;
    }

    //method to read file
    public List<String> readFile() {

        try {
            Scanner reader = new Scanner(file, "UTF-8");
            List<String> content = new ArrayList<String>();
            while (reader.hasNextLine()) {
                content.add(reader.nextLine());
            }
//            System.out.println(content);        //test line
            return content;
        } catch (FileNotFoundException ex) {
            return new ArrayList<String>();
        }
    }

}
