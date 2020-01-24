package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection inspection = new WordInspection(file);
        
        System.out.println("number of words: " + inspection.wordCount());
        System.out.println("number of z words: " + inspection.wordsContainingZ().size());
        System.out.println("number of words ending in l: " + inspection.wordsEndingInL().size());
        System.out.println("list of palindrome words: " + inspection.palindromes());
        System.out.println("list of words with all vowels: " + inspection.wordsWhichContainAllVowels());
    }
}
