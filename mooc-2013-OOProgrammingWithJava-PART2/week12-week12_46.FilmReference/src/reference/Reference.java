/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author leonardo
 */
public class Reference {

    private final RatingRegister reg;

    public Reference(RatingRegister reg) {
        this.reg = reg;
    }

    public Film recommendFilm(Person person) {
        Map<Film, List<Rating>> filmRatings = reg.filmRatings();        //need this for the comparator

        //need a list of existing films
        Set<Film> filmSet = filmRatings.keySet();
        List<Film> existingFilms = new ArrayList<Film>(filmSet);
        
        //if the person has given no reviews, find a film with the highest average rating
        if (this.reg.getPersonalRatings(person).isEmpty()) {
            //System.out.println("TEST LINE - Person has no ratings, recommending film from overall ratings");
            //recommend a film based on it's average ratings
            Collections.sort(existingFilms, new FilmComparator(filmRatings));       //sort the list of existing films in descending order
            if (existingFilms.isEmpty()) {
                System.out.println("TEST LINE - There are no ratings for films");
                return null;
            } else {
                return existingFilms.get(0);        //return the first film in the list sorted by highest rating
            }

        }
        
        //Reaching this stage means the person has given reviews, so let's give a recommendation based on a similar reviewer's preferences
        
        //System.out.println("TEST LINE - Person has ratings, looking for people with similar interests");
        Person mostSimilarReviewer = findMostSimilarReviewer(person);
        
        //System.out.println(mostSimilarReviewer);
        //System.out.println("TEST LINE - Person with similar insterest found. Looking for film to recommend");
        
        Map<Film, Rating> mostSimilarReviewerRaitings =  this.reg.getPersonalRatings(mostSimilarReviewer);
        Map<Film, Rating> personRatings = this.reg.getPersonalRatings(person);
        List<Film> filmsInCommon = new ArrayList<Film>();
        List<Film> filmsForRecommending = new ArrayList<Film>();
        
        for (Film film : mostSimilarReviewerRaitings.keySet()){     //go through each film of the most similar reviewer list
            
            if (personRatings.containsKey(film)){       //if the film is in common with the person looking for a review, we take note of it
                filmsInCommon.add(film);
            } else{     //if it is not in common, then we store it in a list of films for recommending
                filmsForRecommending.add(film);
            }
        }
        
        Film toRecommend = null;
        for (Film film : filmsForRecommending){     //now we find the highest rated film in the films fit for recommendation
            
            if (toRecommend == null || mostSimilarReviewerRaitings.get(film).getValue() > mostSimilarReviewerRaitings.get(toRecommend).getValue()){
                toRecommend = film;
            }
        }
        
        //if the person has watched the same films as the similar interest individual, then the films for recommending list would be empty and therefore no recommendations are available
        if (filmsForRecommending.isEmpty()){
            return null;
        }
        
        //if the best recommendation is rated above neutral, then recommend it
        if (mostSimilarReviewerRaitings.get(toRecommend).getValue() >= 3 ){
            return toRecommend;
        }
        //if it is rated below neutral, then don't make a recommendation
        return null;
    }

    private Person findMostSimilarReviewer(Person lookingForRecommendation) {

        List<Person> reviewersToCompare = this.reg.reviewers();      //get a list of all reviewers
        if (reviewersToCompare.contains(lookingForRecommendation)) {
            reviewersToCompare.remove(lookingForRecommendation);     //remove the person looking for recommendation from the list
        }

        //get the films rated by the person looking for recommendation
        Map<Film, Rating> filmsRated = this.reg.getPersonalRatings(lookingForRecommendation);

        Map<Person, Integer> scores = new HashMap<Person, Integer>();       //here we store the scores for each individual
        //go through the reviewers to compare to find the highest similarity
        for (Person reviewer : reviewersToCompare) {
            Map<Film, Rating> filmsRatedByCompared = this.reg.getPersonalRatings(reviewer);
            
            int sum = 0;
            for (Film film : filmsRated.keySet()) {      //go through each film the person looking for a recommendation has watched
                //now we multiply the ratings that the person looking for a recommendation and the compared person have given to the same film to determine a score
                if (filmsRatedByCompared.get(film) == null){
                    continue;
                }
                sum += filmsRated.get(film).getValue() * filmsRatedByCompared.get(film).getValue();
            }
            
            scores.put(reviewer, sum);      //store the sum as the person's score
        }
        
        //find the person with the highest score
        Person toReturn = null;
        for (Person person : scores.keySet()){
            if (toReturn == null || scores.get(person) > scores.get(toReturn)){
                toReturn = person;
            }
        }

        return toReturn;
    }
}
