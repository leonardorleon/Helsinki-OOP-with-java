/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author leonardo
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> dictionary;

    public PersonalMultipleEntryDictionary() {
        this.dictionary = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        //first deal with the case when the word has not been added to the dictionary
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, new HashSet<String>());        //if the word does not already exist in the dictionary, initiate a hash set for that word
        }

        //now we can add it to the word's assigned hash set
        Set<String> translationsForWord = this.dictionary.get(word);        //access the set of translations for the given word
        translationsForWord.add(entry);     //add the entry to the set
    }

    @Override
    public Set<String> translate(String word) {

        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }

        return null;        //return null if the dictionary does not contain the word
    }

    @Override
    public void remove(String word) {
        dictionary.remove(word);        //remove a word and all its entries from the dictionary
    }

}
