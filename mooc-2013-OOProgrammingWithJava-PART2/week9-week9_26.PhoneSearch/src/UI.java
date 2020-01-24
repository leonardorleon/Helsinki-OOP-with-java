
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
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
public class UI {

    private Scanner reader;
    private Directory directory;

    public UI(Scanner reader, Directory directory) {
        this.reader = reader;
        this.directory = directory;
    }

    public void start() {
        System.out.println("phone search");

        System.out.println("available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");

        String command = "palceholder";     //set the variable command to a placeholder before going into the directory loop

        while (!command.equals("x")) {       //continue asking for a new command until the user inputs "x"
            System.out.print("\ncommand: ");
            command = reader.nextLine();

            if (command.equals("1")) {
                String name = askForName();
                String number = askForNumber();
                addNumber(name, number);        //call the add number method to add it to the directory
            }

            if (command.equals("2")) {
                String contactName = askForName();
                //first check if there is a contact with that name in the directory
                if (directory.isInDirectory(contactName)){
                    Contact contact = directory.getContact(contactName);
                    printNumbers(contact);
                } else {
                    System.out.println("  not found");
                }
            }

            if (command.equals("3")) {
                //System.out.println("WORK IN PROGRESS - name search by phone number");
                String number = askForNumber();
                System.out.println(directory.searchForName(number));
            }

            if (command.equals("4")) {
                //System.out.println("WORK IN PROGRESS - adding an address to the relative person");
                List<String> nameAndAddress = askForAddress();
                String name = nameAndAddress.get(0);        //take the name        
                String address = nameAndAddress.get(1);     //take the address       
                if (!directory.isInDirectory(name)){       //if the given name is not in the directory, create a new contact for it
                    directory.add(name, new Contact(name));     //add a new contact to the directory only specifying the name
                }
                Contact contact = directory.getContact(name);       //grab the contact from the directory, wether it was just created or it was there previously
                contact.setAddress(address);        //set the addres for the specified contact
                
            }

            if (command.equals("5")) {
                //System.out.println("WORK IN PROGRESS - personal information search (search for a person's address and phone number)");
                String name = askForInformation();
                if (directory.isInDirectory(name)){
                    System.out.println(directory.getContact(name));
                } else{
                    System.out.println("  not found");
                }
                
            }

            if (command.equals("6")) {
                //System.out.println("WORK IN PROGRESS - removing a person's information");
                String name = askForInformation();
                directory.removeContact(name);
            }

            if (command.equals("7")) {
                //System.out.println("WORK IN PROGRESS - filtered search by keyword (retrieving a list which must be sorted by name in alphabetic order), the keyword can appear in the name or address");
                String keyword = askForKeyword();
                List<Contact> results = directory.searchForKeyword(keyword);
                //go through each contact in the results and print them
                for (Contact contact : results){
                    System.out.println("\n " +contact.getName());
                    System.out.println(contact);
                }
            }

        }
    }

    public String askForName() {
        System.out.print("whose number: ");
        return reader.nextLine();
    }

    public String askForNumber() {
        System.out.print("number: ");
        return reader.nextLine();
    }
    
    public String askForInformation(){
        System.out.print("whose information: ");
        return reader.nextLine();
    }
    
    public List<String> askForAddress(){
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String address = reader.nextLine();
        System.out.print("city: ");
        address += " " + reader.nextLine();
        
        List<String> toBeReturned = new ArrayList<String>();
        toBeReturned.add(name);
        toBeReturned.add(address);
        return toBeReturned;
    }
    
    public String askForKeyword(){
        System.out.print("keyword (if empty, all listed): ");
        return reader.nextLine();
    }

    //method to print numbers in a list
    public void printNumbers(Contact contact) {
        List<String> numbers = contact.getNumbers();
        numbers.remove("");     //clean the numbers list of any empty strings
        for (String number : numbers) {
            System.out.println(" " + number);
        }
    }

    public void addNumber(String name, String number) {
        //if the name is not a contact in the directory, create one first
        if (!directory.isInDirectory(name)) {
            Contact toAdd = new Contact(name);      //generate the contact to be added to the directory
            directory.add(name, toAdd);     //add the contact to the diretory with its name as key
        }
        // get the contact from the directory and add a number to it
        Contact contact = directory.getContact(name);
        contact.addNumber(number);
    }
}
