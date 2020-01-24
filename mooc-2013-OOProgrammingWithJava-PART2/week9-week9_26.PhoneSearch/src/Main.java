
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        Directory directory = new Directory();
        Scanner reader = new Scanner(System.in);
        //start the directory UI
        UI ui = new UI(reader, directory);
        ui.start();
    }
}
