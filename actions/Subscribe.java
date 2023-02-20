package actions;

import input.ActionsInput;
import platform.Input;
import platform.Movie;
import platform.Platform;

public class Subscribe extends BasicAction {
    /**
     * this function subscribes the user to a genre
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        if (!Platform.getInstance().getCurrentPage().equals("see details")) {
             return 0;
        }
        if (Platform.getInstance().getCurrentUser().getSubscriptions().contains(currentAction.
                getSubscribedGenre())) {
            return 0;
        }
        for (Movie movie: Platform.getInstance().getAllMovies()) {
            if (movie.getName().equals(Platform.getInstance().getSeeDetailsMovie())) {
                if (!movie.getGenres().contains(currentAction.getSubscribedGenre())) {
                    return 0;
                }
            }
        }
        Platform.getInstance().getCurrentUser().getSubscriptions().add(currentAction.
                getSubscribedGenre());
        return 1;
    }
}
