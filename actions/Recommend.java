package actions;

import observers.Notification;
import platform.Movie;
import platform.Platform;
import platform.TopGenre;

import java.util.ArrayList;
import java.util.Collections;


public class Recommend {
    /**
     * this function sorts all the genres based on their likes, and then alfabetically
     * @param topGenres
     */
    public static void sortTopGenre(final ArrayList<TopGenre> topGenres) {
        Collections.sort(topGenres, (genre1, genre2) -> {
            if (genre1.getLikes() != genre2.getLikes()) {
                    return genre2.getLikes() - genre1.getLikes();
            } else {
                return genre1.getGenre().compareTo(genre2.getGenre());
            }
        });
    }

    /**
     * this function sorts all the available movies based on their number of likes
     * and then alfabetically
     * @param movies
     */
    public static void sortMovies(final ArrayList<Movie> movies) {
        Collections.sort(movies, (movie1, movie2) -> {
            if (movie1.getNumLikes() != movie2.getNumLikes()) {
                return movie2.getNumLikes() - movie1.getNumLikes();
            }
            return movie1.getName().compareTo(movie2.getName());
        });
    }

    /**
     * this function uses all the functions above and finds for the current user
     * the best movie and puts it as a recommendation in his notifications
     * the best movie is the one the user has not seen and contains one of the genres
     * the user likes the most
     * @return
     */
    public static int action() {
        if (Platform.getInstance().getCurrentUser() == null) {
            return 0;
        }
        if (Platform.getInstance().getCurrentUser().getAccountType().equals("standard")) {
            return 0;
        }
        if (Platform.getInstance().getCurrentUser() == null) {
            return 0;
        }
        ArrayList<TopGenre> topGenres = new ArrayList<TopGenre>();
        for (Movie movie: Platform.getInstance().getCurrentUser().getLikedMovies()) {
            for (String genres: movie.getGenres()) {
                int ok = 0;
                for (TopGenre tgenre: topGenres) {
                    if (tgenre.getGenre().equals(genres)) {
                        tgenre.setLikes(tgenre.getLikes() + 1);
                        ok = 1;
                    }
                }
                if (ok == 0) {
                    TopGenre tgenre = new TopGenre();
                    tgenre.setGenre(genres);
                    tgenre.setLikes(1);
                    topGenres.add(tgenre);
                }
            }
        }
        ArrayList<Movie> allMovies = new ArrayList<Movie>();
        for (Movie movie : Platform.getInstance().getAllMovies()) {
            allMovies.add(movie);
        }
        sortMovies(allMovies);
        sortTopGenre(topGenres);
        Notification notification = new Notification();
        notification.setMessage("Recommendation");
        int ok = 0;
        for (TopGenre genre: topGenres) {
            for (Movie movie: allMovies) {
                if (movie.getGenres().contains(genre.getGenre()) && !Platform.getInstance().
                        getCurrentUser().getWatchedMovies().contains(movie)) {
                    notification.setMovieName(movie.getName());
                    ok = 1;
                    break;
                }
            }
        }
        if (ok == 0) {
            notification.setMovieName("No recommendation");
        }
        Platform.getInstance().getCurrentUser().getNotifications().add(notification);
        return 1;
    }
}
