
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leonardo
 */
public class Contact implements Comparable<Contact> {

    private String name;
    private List<String> numbers;
    private String address;

    public Contact(String name, String number, String address) {
        this.name = name;
        this.numbers = new ArrayList<String>();
        this.numbers.add(number);
        this.address = address;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.numbers = new ArrayList<String>();
        this.numbers.add(number);
        this.address = "address unknown";
    }

    public Contact(String name) {
        this.name = name;
        this.numbers = new ArrayList<String>();
        this.address = "address unknown";
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    @Override
    public String toString() {
        List<String> numList = getNumbers();
        if (numList.isEmpty()) {
            String toBeReturned = "  address: " + getAddress() + "\n  phone number not found\n";
            return toBeReturned;
        } else {
            String toBeReturned = "  address: " + getAddress() + "\n  phone numbers:";
            
            String numberString = "";
            for (String number : numList) {
                numberString += "\n   " + number;
            }

            toBeReturned += numberString;
            return toBeReturned;
        }
    }

    @Override
    public int compareTo(Contact o) {
        return getName().compareTo(o.getName());
    }

}
