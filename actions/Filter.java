package actions;
import input.ActionsInput;
import platform.Platform;
import platform.Movie;
import platform.Input;
import java.util.ArrayList;
import java.util.Collections;

public final class Filter extends BasicAction {
    /**
     * If the uses wants to filter the movies that he can purchase, he should use this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        ArrayList<Movie> aux = new ArrayList<Movie>();
        aux.addAll(Platform.getInstance().getMovies());
        var contains = currentAction.getFilters().getContains();
        var all = Platform.getInstance().getMovies();
        if (currentAction.getFilters().getContains() != null) {
            if (currentAction.getFilters().getContains().getActors().size() != 0) {
                Platform.getInstance().getMovies().removeAll(Platform.getInstance().getMovies());
                for (String actor : currentAction.getFilters().getContains().getActors()) {
                    for (Movie movie : aux) {
                        if (movie.getActors().contains(actor)) {
                            Platform.getInstance().getMovies().add(movie);
                        }
                    }
                }
            }
            if (currentAction.getFilters().getContains().getGenre().size() != 0) {
                aux.removeAll(aux);
                aux.addAll(Platform.getInstance().getMovies());
                Platform.getInstance().getMovies().removeAll(Platform.getInstance().getMovies());
                for (String genre : currentAction.getFilters().getContains().getGenre()) {
                    for (Movie movie : aux) {
                        if (movie.getGenres().contains(genre)) {
                            Platform.getInstance().getMovies().add(movie);
                        }
                    }
                }
            }
        }
        var out = currentAction.getFilters().getSort();
        if (currentAction.getFilters().getSort() != null) {
            if (currentAction.getFilters().getSort().getDuration() != null
                    && currentAction.getFilters().getSort().getRating() != null) {
                Collections.sort(Platform.getInstance().getMovies(), (movie1, movie2) -> {
                    if (movie1.getDuration() != movie2.getDuration()) {
                        if (currentAction.getFilters()
                                .getSort().getDuration().equals("increasing")) {
                            return movie1.getDuration() - movie2.getDuration();
                        }
                        return movie2.getDuration() - movie1.getDuration();
                    } else {
                        if (currentAction.getFilters()
                                .getSort().getRating().equals("increasing")) {
                            return movie1.getRating().compareTo(movie2.getRating());
                        }
                        return movie2.getRating().compareTo(movie1.getRating());
                    }
                });
            } else if (currentAction.getFilters().getSort().getDuration() == null) {
                if (currentAction.getFilters().getSort()
                        .getRating().equals("increasing")) {
                    Collections.sort(Platform.getInstance().getMovies(), (movie1, movie2)
                            -> movie1.getRating().compareTo(movie2.getRating()));
                } else {
                    Collections.sort(Platform.getInstance().getMovies(), (movie1, movie2)
                            -> movie2.getRating().compareTo(movie1.getRating()));
                }
            } else if (currentAction.getFilters().getSort().getRating() == null) {
                if (currentAction.getFilters().getSort().getDuration().equals("increasing")) {
                    Collections.sort(Platform.getInstance().getMovies(), (movie1, movie2)
                            -> (movie1.getDuration() - movie2.getDuration()));
                } else {
                    Collections.sort(Platform.getInstance().getMovies(), (movie1, movie2)
                            -> (movie2.getDuration() - movie1.getDuration()));
                }
            }
        }
        return 1;
    }
}
