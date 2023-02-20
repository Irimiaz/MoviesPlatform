package actions;

import input.ActionsInput;
import platform.Input;
import platform.Platform;
import platform.Movie;
import java.util.ArrayList;

public class Search extends BasicAction {
    /**
     * If the user wants to Search for a specific Movie, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        ArrayList<Movie> aux = new ArrayList<Movie>();
        aux.addAll(Platform.getInstance().getMovies());
        Platform.getPlatform().getSearchedMovies().addAll(Platform.getInstance().getMovies());
        Platform.getInstance().getMovies().removeAll(Platform.getInstance().getMovies());
        for (Movie movie : aux) {
            if (movie.getName().indexOf(currentAction.getStartsWith()) == 0) {
                Platform.getInstance().getMovies().add(movie);
            }
        }
        return 1;
    }
}
