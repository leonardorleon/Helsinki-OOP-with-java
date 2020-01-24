
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Scanner reader = new Scanner(System.in);
        System.out.print("give a string: ");
        String string = reader.nextLine();
        //System.out.println(isAWeekDay(string));
        //System.out.println(allVowels(string));
        System.out.println(clockTime(string));
    }

    public static boolean isAWeekDay(String string) {

        return string.matches("(mon|tue|wed|thu|fri|sat|sun)");
    }

    public static boolean allVowels(String string) {

        return string.matches("[aeiouäö]*");
    }

    public static boolean clockTime(String string) {
        return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");
    }
}
