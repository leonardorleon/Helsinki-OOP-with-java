
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getRingingYear() {
        return ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    public boolean equals(Object object){
       if (object == null){
           return false;
       }
       
       if (getClass() != object.getClass()){
           return false;
       }
       
       //now that we've made sure the object is not empty and it is the same type as tis object, we can differentiate between similar objects

       Bird compared = (Bird) object;       //let's treat the object as a bird object
       
       if (getLatinName().equals(compared.getLatinName()) && getRingingYear() == compared.getRingingYear()){
           return true;     //return true if the compared bird object has the same latin name and ringing year.
       }
       
       return false;
       
    }

    @Override
    public int hashCode() {
        return this.getRingingYear() + this.getLatinName().hashCode();
    }
    
    
}


