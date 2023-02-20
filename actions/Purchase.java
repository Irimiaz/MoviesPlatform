package actions;

import input.ActionsInput;
import platform.Platform;
import platform.Movie;
import platform.Input;

public class Purchase extends BasicAction {
    private int ok = 0;
    static final int PURCHASECOST = 2;
    static final int DECREASEFREEMOVIES = 1;

    /**
     * The uses uses this function if he wants to purchase a movie
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        if (Platform.getPlatform().getSeeDetailsMovie() != null) {
            for (Movie movie : Platform.getInstance().getMovies()) {
                if (movie.getName().equals(Platform.getPlatform().getSeeDetailsMovie())
                        && !Platform.getInstance().getCurrentUser().
                        getPurchasedMovies().contains(movie)) {
                    Platform.getInstance().getCurrentUser().getPurchasedMovies().add(movie);
                    ok = 1;
                    if (Platform.getInstance().getCurrentUser().
                            getAccountType().equals("standard")) {
                        Platform.getInstance().getCurrentUser().
                                setTokensCount(Platform.getInstance().
                                        getCurrentUser().getTokensCount() - 2);
                    } else {
                        if (Platform.getInstance().getCurrentUser().getNumFreePremiumMovies() > 0) {
                            Platform.getInstance().getCurrentUser().
                                    setNumFreePremiumMovies(Platform.getInstance().
                                    getCurrentUser().getNumFreePremiumMovies() - 1);
                        } else {
                            Platform.getInstance().getCurrentUser().
                                    setTokensCount(Platform.getInstance().
                                            getCurrentUser().getTokensCount() - 2);
                        }
                    }
                }
            }
        } else {
            return 0;
        }
        return ok;
    }
}
