
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leonardo
 */
public class RingingCentre {

    private final Map<Bird, List<String>> observations = new HashMap<Bird, List<String>>();

    public RingingCentre() {
    }

    public void observe(Bird bird, String place) {
        //access the bird observation hasmap and add the place
        if (!observations.containsKey(bird)) {
            observations.put(bird, new ArrayList<String>());
        }

        //if the bird is existing in the hasMap, add the element to the list
        observations.get(bird).add(place);
    }

    public void observations(Bird bird) {
        try {
            List<String> birdObervations = observations.get(bird);
            if (!observations.containsKey(bird)) {
                System.out.println(bird.getLatinName() + " (" + bird.getRingingYear() + ") " + "observations: " + 0);
                return;
            }

            System.out.println(bird.getLatinName() + " (" + bird.getRingingYear() + ") " + "observations: " + observations.get(bird).size());
            List<String> placesObserved = observations.get(bird);
            for (String place : placesObserved){
                System.out.println(place);
            }
        } catch (NullPointerException e) {

        }
    }

}
