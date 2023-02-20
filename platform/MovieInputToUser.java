package platform;
import input.MoviesInput;

public class MovieInputToUser {
    /**
     * this function convers a MovieInput variable to Movie
     * @param userInput
     * @return
     */
    public static Movie movieInputToMovie(final MoviesInput userInput) {
        Movie movie = new Movie(userInput.getName(), userInput.getYear(), userInput.getDuration());
        movie.setActors(userInput.getActors());
        movie.setGenres(userInput.getGenres());
        movie.setCountriesBanned(userInput.getCountriesBanned());
        return movie;
    }
}
