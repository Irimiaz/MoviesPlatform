package observers;

import platform.Movie;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * this function gets a movie
     * @return
     */
    public Movie getMovie() {
        return this.movie;
    }

    /**
     * this function updates all the observers
     * @param movie
     */
    public void setMovie(final Movie movie) {
        this.movie = movie;
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * this function creates a new observer
     * @param observer
     */
    public void attach(final Observer observer) {
        observers.add(observer);
    }
    private Movie movie;

}
