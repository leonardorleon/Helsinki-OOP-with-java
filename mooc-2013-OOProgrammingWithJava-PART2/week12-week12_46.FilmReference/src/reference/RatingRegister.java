/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author leonardo
 */
public class RatingRegister {

    Map<Film, List<Rating>> ratings;
    Map<Person, Map<Film, Rating>> personalRatings;
    //Map<Film, Rating> filmsRatedByPerson;

    public RatingRegister() {
        this.ratings = new HashMap<Film, List<Rating>>();
        this.personalRatings = new HashMap<Person, Map<Film, Rating>>();
        //this.filmsRatedByPerson = new HashMap<Film, Rating>();
    }

    public void addRating(Film film, Rating rating) {
        if (this.ratings.containsKey(film)) {
            this.ratings.get(film).add(rating);
        } else {
            List<Rating> newList = new ArrayList<Rating>();
            newList.add(rating);
            this.ratings.put(film, newList);
        }
    }

    public void addRating(Person person, Film film, Rating rating) {
//        if (this.personalRatings.containsKey(person) && !this.personalRatings.get(person).containsKey(film)) {
        if (this.personalRatings.containsKey(person)) {
            Map<Film, Rating> personReviews = this.personalRatings.get(person);     //obtain the existing map of personal reviews done by the person
            personReviews.put(film, rating); 
            this.personalRatings.put(person, personReviews);       //Add this person's new review to the list of personal ratings
            addRating(film, rating);        //add the rating to the overall list of ratings
            
        } else {
            Map<Film, Rating> personReviews = new HashMap<Film, Rating>();     //create a new map of films reviewed by the person
            personReviews.put(film, rating);        
            this.personalRatings.put(person, personReviews);      //add the map of films reviwed by the person to the map of personal ratings
            addRating(film, rating);        //add the rating of the film to the overall list of ratings per film
        }
    }

    public Rating getRating(Person person, Film film) {
        Map<Film, Rating> ratingsByThisPerson = this.personalRatings.get(person);       //pull up the films this person has rated

        if (ratingsByThisPerson.containsKey(film)) {        //check that the film has been rated by this person 
            return ratingsByThisPerson.get(film);
        } else {
            return Rating.NOT_WATCHED;      //return not watched if the person has not rated this film
        }
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (this.personalRatings.containsKey(person)){
            return this.personalRatings.get(person);
        }else{
            return new HashMap<Film, Rating>();
        }
    }

    public List<Person> reviewers() {
        List<Person> listOfReviewers = new ArrayList<Person>();
        listOfReviewers.addAll(this.personalRatings.keySet());
        return listOfReviewers;
    }

    public List<Rating> getRatings(Film film) {
        return this.ratings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return this.ratings;
    }

}
