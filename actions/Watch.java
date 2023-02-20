package actions;

import input.ActionsInput;
import platform.Input;
import platform.Platform;
import platform.Movie;


public class Watch extends BasicAction {
    private int ok = 0;
    /**
     * if the user wants to watch a specific and
     * move it to the watchedMovies section, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        if (Platform.getPlatform().getSeeDetailsMovie() != null) {
            for (Movie movie : Platform.getInstance().getCurrentUser().getPurchasedMovies()) {
                if (movie.getName().equals(Platform.getPlatform().getSeeDetailsMovie())) {
                    if (!Platform.getInstance().getCurrentUser().getWatchedMovies().
                            contains(movie)) {
                        Platform.getInstance().getCurrentUser().getWatchedMovies().add(movie);
                    }
                    ok = 1;
                }
            }
        } else {
            return 0;
        }
        return ok;
    }
}
