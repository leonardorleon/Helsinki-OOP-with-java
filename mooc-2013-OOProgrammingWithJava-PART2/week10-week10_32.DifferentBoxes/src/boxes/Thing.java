package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if (weight < 0){
            throw new IllegalArgumentException("The weight of the thing cannot be negative");
        }
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        //self check
        if (this == obj){
            return true;
        }
        
        //null check
        if (obj == null){
            return false;
        }
        
        //type check and cast
        if (this.getClass() != obj.getClass()){
            return false;
        }
        
        Thing thing = (Thing) obj;
        //field comparison
        return this.getName().equals(thing.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

}
