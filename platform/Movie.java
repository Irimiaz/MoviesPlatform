package platform;


import java.util.ArrayList;

public class Movie {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres = new ArrayList<String>();
    private ArrayList<String> actors = new ArrayList<String>();
    private ArrayList<String> countriesBanned = new ArrayList<String>();
    private int numLikes;
    private Double rating;
    private int numRatings;
    public Movie(final String name, final String year, final int duration) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.numRatings = 0;
        this.numLikes = 0;
        this.rating = 0.00;
        this.totalRating = 0;
    }
    public Movie(final Movie movie) {
        this.name = new String(movie.getName());
        this.year = new String(movie.getYear());
        this.duration = Integer.valueOf(movie.getDuration());
        this.numLikes = Integer.valueOf(movie.getNumLikes());
        this.rating = Double.valueOf(movie.getRating());
        this.numRatings = Integer.valueOf(movie.getNumRatings());
    }

    /**
     * this function gets movie's name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * this function sets movie's name
     * @return
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * this function gets movie's year
     * @return
     */
    public String getYear() {
        return year;
    }
    /**
     * this function sets movie's year
     * @return
     */
    public void setYear(final String year) {
        this.year = year;
    }
    /**
     * this function gets movie's duration
     * @return
     */
    public int getDuration() {
        return duration;
    }
    /**
     * this function sets movie's duration
     * @return
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }
    /**
     * this function gets movie's genres
     * @return
     */
    public ArrayList<String> getGenres() {
        return genres;
    }
    /**
     * this function sets movie's genres
     * @return
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }
    /**
     * this function gets movie's actors
     * @return
     */
    public ArrayList<String> getActors() {
        return actors;
    }
    /**
     * this function sets movie's actors
     * @return
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }
    /**
     * this function gets movie's banned countries
     * @return
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    /**
     * this function sets movie's banned countries
     * @return
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
    /**
     * this function gets movie's number of likes
     * @return
     */
    public int getNumLikes() {
        return numLikes;
    }
    /**
     * this function sets movie's number of likes
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
    private int totalRating;
    /**
     * this function gets movie's rating
     * @return
     */
    public void setRating(final Double rating) {
        this.rating = rating;
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


}
