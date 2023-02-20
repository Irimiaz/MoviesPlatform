package input;

import java.util.ArrayList;

public class MoviesInput {
    /**
     * returns movie name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * returns movie year
     * @return
     */
    public String getYear() {
        return year;
    }
    /**
     * returns movie duration
     * @return
     */
    public int getDuration() {
        return duration;
    }
    /**
     * returns movie genres
     * @return
     */
    public ArrayList<String> getGenres() {
        return genres;
    }
    /**
     * returns movie actors
     * @return
     */
    public ArrayList<String> getActors() {
        return actors;
    }
    /**
     * returns movie countries banned
     * @return
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    private String name;
    private String year;

    /**
     * this funstion sets movie's duration
     * @param duration
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * this function gets movie's number of ratings
     * @return
     */
    public int getNumRatings() {
        return numRatings;
    }
    /**
     * this function sets movie's number of ratings
     * @return
     */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }
    /**
     * this function gets movie's number of likes
     * @return
     */
    public int getNumLikes() {
        return numLikes;
    }
    /**
     * this function sets movie's number of ratings
     * @return
     */
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }
    /**
     * this function gets movie's rating
     * @return
     */
    public Double getRating() {
        return rating;
    }
    /**
     * this function sets movie's rating
     * @return
     */
    public void setRating(final Double rating) {
        this.rating = rating;
    }
    /**
     * this function gets movie's total rating
     * @return
     */
    public int getTotalRating() {
        return totalRating;
    }
    /**
     * this function sets movie's total rating
     * @return
     */
    public void setTotalRating(final int totalRating) {
        this.totalRating = totalRating;
    }

    private int duration;
    private int numRatings;

    private int numLikes;
    private Double rating;
    private int totalRating;
    private ArrayList<String> genres = new ArrayList<String>();
    private ArrayList<String> actors = new ArrayList<String>();
    private ArrayList<String> countriesBanned = new ArrayList<String>();
}
