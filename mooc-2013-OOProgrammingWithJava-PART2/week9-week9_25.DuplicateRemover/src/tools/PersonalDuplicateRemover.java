/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author leonardo
 */
public class PersonalDuplicateRemover implements DuplicateRemover{
    
    private Set<String> uniquesList;
    //private Set<String> duplicatesList;
    private int duplicatesNumber;
    
    public PersonalDuplicateRemover(){
        this.uniquesList = new HashSet<String>();
        //this.duplicatesList = new HashSet<String>();
        this.duplicatesNumber = 0;
        
    }
    
    //method to add a string to the character string set list, unless it is a duplicate
    @Override
    public void add(String characterString) {
        
        if (uniquesList.contains(characterString)){
            //duplicatesList.add(characterString);
            duplicatesNumber++;
        } else {
            uniquesList.add(characterString);
        }
        
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicatesNumber;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return uniquesList;
    }

    @Override
    public void empty() {
        uniquesList.clear();
        duplicatesNumber = 0;
    }
    
}
