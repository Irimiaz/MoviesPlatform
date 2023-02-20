package actions;

import input.ActionsInput;
import platform.Input;
import platform.Movie;
import platform.Platform;

public class Like extends BasicAction {
    /**
     * If the user wants to like a movie, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        int ok = 0;
        if (Platform.getPlatform().getSeeDetailsMovie() != null) {
            for (Movie movie : Platform.getInstance().getCurrentUser().getPurchasedMovies()) {
                if (movie.getName().equals(Platform.getPlatform().getSeeDetailsMovie())) {
                    if (!Platform.getInstance().getCurrentUser().getLikedMovies().contains(movie)) {
                        Platform.getInstance().getCurrentUser().getLikedMovies().add(movie);
                        movie.setNumLikes(movie.getNumLikes() + 1);
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
