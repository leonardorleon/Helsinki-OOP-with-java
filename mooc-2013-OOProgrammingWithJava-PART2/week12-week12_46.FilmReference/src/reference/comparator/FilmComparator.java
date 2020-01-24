/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author leonardo
 */
public class FilmComparator implements Comparator<Film> {

    private final Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.ratings = ratings;
    }
    
    @Override
    public int compare(Film o1, Film o2) {
        return average(o2) - average(o1);       //Rates films in descending order. ratings with higher average should be placed first for recommendations
    }

    private int average(Film o) {
        int sum = 0;
        List<Rating> oRatings = ratings.get(o);
        for (Rating rating : oRatings){
            sum += rating.getValue();
        }
        
        return sum/oRatings.size();
    }
    
}
