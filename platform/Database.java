package platform;

import observers.NotifyAllObserverAdd;
import observers.NotifyAllObserverDelete;
import observers.RemoveMovie;
import observers.Subject;

import java.util.ArrayList;

public class Database {
    /**
     * this function returns all the movies in the database
     * @return
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    /**
     * this function adds a new movie to the database
     * and notifies all the observers
     * @param movie
     * @return
     */
    public int databaseAdd(final Movie movie) {
        for (Movie newMovie : this.movies) {
            if (newMovie.getName().equals(movie.getName())) {
                return 0;
            }
        }
        for (Movie newMovie : Platform.getInstance().getAllMovies()) {
            if (newMovie.getName().equals(movie.getName())) {
                return 0;
            }
        }
        Subject subject = new Subject();
        new NotifyAllObserverAdd(subject);
        this.movies.add(movie);
        subject.setMovie(movie);
        return 1;
    }

    /**
     * this function deletes a movie from the database
     * and notifies all the observers
     * @param movie
     * @return
     */
    public int databaseDelete(final Movie movie) {
        int ok = 0;
        for (Movie newMovie : this.movies) {
            if (newMovie.getName().equals(movie.getName())) {
                ok = 1;
            }
        }
        if (ok == 0) {
            return 0;
        }
        Subject subject = new Subject();
        new NotifyAllObserverDelete(subject);
        new RemoveMovie(subject);
        this.movies.remove(movie);
        subject.setMovie(movie);
        return 1;
    }
}
