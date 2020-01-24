
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();

        for (String line : t.read("src/testinput1.txt")) {
            System.out.println(line);
        }
        
        
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("one");
        testList.add("two");
        testList.add("three");
        
        String testString = "test string contents";
        
        t.save("src/testinput3.txt", testString);
        
        t.save("src/testinput3.txt", testList);
        
//        System.out.println("using read function");
//        
//        ArrayList<String> test = (ArrayList < String >) t.read("src/testinput1.txt");
//        for (String line : test){
//            System.out.println(line);
//        }
        
    }
}
