package actions;

import input.ActionsInput;
import platform.Movie;
import platform.Input;
import platform.Platform;
import platform.RatedMovie;

public class Rate extends BasicAction {
    private int ok = 0;
    private static final int MAXRATING = 5;

    /**
     * If the user wants to rate a movie, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        if (currentAction.getRate() >= 0 && currentAction.getRate() <= MAXRATING
                && Platform.getPlatform().getSeeDetailsMovie() != null) {
            for (Movie movie : Platform.getInstance().getCurrentUser().getPurchasedMovies()) {
                if (movie.getName().equals(Platform.getPlatform().getSeeDetailsMovie())) {
                    RatedMovie ratedMovie = new RatedMovie();
                    ratedMovie.setMovie(movie);
                    ratedMovie.setRate(currentAction.getRate());
                    for (RatedMovie movies : Platform.getInstance().getCurrentUser().getRates()) {
                        if (movie.getName().equals(movies.getMovie().getName())) {
                            movie.setTotalRating(movie.getTotalRating() + currentAction.getRate()
                                    - movies.getRate());
                            movie.setRating(((double) movie.getTotalRating()
                                    / movie.getNumRatings()));
                            return 1;
                        }
                    }
                    Platform.getInstance().getCurrentUser().getRates().add(ratedMovie);

                    if (!Platform.getInstance().getCurrentUser().getRatedMovies().contains(movie)) {
                        Platform.getInstance().getCurrentUser().getRatedMovies().add(movie);
                        movie.setNumRatings(movie.getNumRatings() + 1);

                    }
                    movie.setTotalRating(movie.getTotalRating() + currentAction.getRate());
                    movie.setRating(((double) movie.getTotalRating() / movie.getNumRatings()));
                    ok = 1;
                }
            }
        } else {
            return 0;
        }
        return ok;
    }
}
