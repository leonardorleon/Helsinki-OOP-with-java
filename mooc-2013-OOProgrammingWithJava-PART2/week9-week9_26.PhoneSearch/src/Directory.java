
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leonardo
 */
public class Directory {

    private Map<String, Contact> directory;

    public Directory() {
        this.directory = new HashMap<String, Contact>();
    }

    //method to add a contact to the directory
    public void add(String name, Contact contact) {
        this.directory.put(name, contact);
    }

    public Map<String, Contact> getDirectory() {
        return directory;
    }

    public Contact getContact(String name) {
        return directory.get(name);
    }

    public boolean isInDirectory(String name) {
        if (directory.containsKey(name)) {
            return true;
        }

        return false;
    }

    public String searchForName(String number) {

        for (String name : directory.keySet()) {
            List<String> numbers = directory.get(name).getNumbers();    //get the list of numbers for the current contact
            if (numbers.contains(number)) {
                return " " + name;
            }
        }

        return " not found";
    }

    public void removeContact(String name) {
        if (directory.containsKey(name)) {
            directory.remove(name);
        } else {
            System.out.println(" contact not in directory");
        }
    }

    public List<Contact> searchForKeyword(String keyword) {
        List<Contact> toBeReturned = new ArrayList<Contact>();
        if (keyword.equals("")) {
            toBeReturned.addAll(directory.values());        //if no keyword is given, return all contacts in the directory
        } else {
            for (String name : directory.keySet()) {
                if (name.contains(keyword)) {
                    toBeReturned.add(directory.get(name));      //if the name contains the keword, add the contact to the list
                } else if (directory.get(name).getAddress().contains(keyword)) {
                    toBeReturned.add(directory.get(name));      //if the address contains the keyword, add the contact to the list
                }
            }
        }

        Collections.sort(toBeReturned);
        if (toBeReturned.isEmpty()){
            System.out.println(" keyword not found");
        }
        
        return toBeReturned;
    }
}
