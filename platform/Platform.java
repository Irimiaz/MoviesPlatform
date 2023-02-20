package platform;

import java.util.ArrayList;

public final class Platform {
    private static Platform platform = null;
    private Platform() { }

    /**
     * Platform is created using Singleton Design Patter which reduces memory usage
     * @return
     */
    public static Platform getInstance() {
        if (platform == null) {
            platform = new Platform();
        }
        return platform;
    }

    /**
     * this function is used to free all the memory used
     */
    public static void removeInstance() {
        platform = null;
    }

    public ArrayList<Movie> getSearchedMovies() {
        return searchedMovies;
    }

    public void setSearchedMovies(final ArrayList<Movie> searchedMovies) {
        this.searchedMovies = searchedMovies;
    }

    private ArrayList<Movie> searchedMovies = new ArrayList<Movie>();

    public String getSeeDetailsMovie() {
        return seeDetailsMovie;
    }

    public void setSeeDetailsMovie(final String seeDetailsMovie) {
        this.seeDetailsMovie = seeDetailsMovie;
    }

    private String seeDetailsMovie;

    public int getSeeDetailsMovieRating() {
        return seeDetailsMovieRating;
    }

    public void setSeeDetailsMovieRating(final int seeDetailsMovieRating) {
        this.seeDetailsMovieRating = seeDetailsMovieRating;
    }

    public ArrayList<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(final ArrayList<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    private ArrayList<Movie> allMovies = new ArrayList<Movie>();

    public static void setPlatform(final Platform platform) {
        Platform.platform = platform;
    }
    private int seeDetailsMovieRating;

    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }


    public static Platform getPlatform() {
        return platform;
    }

    private User currentUser;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    private ArrayList<Movie> movies = new ArrayList<>();
    public User getCurrentUser() {
        return currentUser;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(final String currentPage) {
        this.currentPage = currentPage;
    }

    private String currentPage;

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }
    private ArrayList<User> allUsers = new ArrayList<User>();

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(final Database database) {
        this.database = database;
    }

    private Database database = new Database();

    public ArrayList<Movie> getBeforeFiltered() {
        return beforeFiltered;
    }

    private ArrayList<Movie> beforeFiltered = new ArrayList<Movie>();
}
