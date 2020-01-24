
public class Main {

    public static void main(String[] args) {
        //int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] t = {1, 2, 3, 4};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        
        StringBuilder toReturn = new StringBuilder();
        
        toReturn.append('{');
        toReturn.append("\n");
        
        
        for (int i=1; i<=t.length; i++){
            toReturn.append(" ");
            toReturn.append(t[i-1]);        //append the next character
            
            if (i != t.length){     //if i is not the last value, add a comma and space
                toReturn.append(",");
            }
            
            if (i % 4 == 0 && i != t.length){        //after every 4 characters add a line break except for the last character
                toReturn.append("\n");
            }
        }
        
        toReturn.append("\n");
        toReturn.append("}");
        
        return toReturn.toString();
    }
}
