
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File fileContents = new File(file);             //create a file variable with the file pathname
        Scanner reader = new Scanner(fileContents);     //read from the file
        ArrayList<String> toReturn = new ArrayList<String>();
        while (reader.hasNextLine()){
            toReturn.add(reader.nextLine());        //store each line into an array list
        }
        reader.close();     //close the file when done.
        return toReturn;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);       //initiate the filewriter for the given file
        writer.write(text);     //replace the existing text on the file with the given text
        writer.close();     //close the file writer
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (String line : texts){
            writer.write(line + "\n");
        }
        writer.close();
    }
}
