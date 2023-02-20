package observers;


public class Notification {
    private String movieName;

    /**
     * function that returns movie name
     * @return
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * function that sets movie name
     * @return
     */
    public void setMovieName(final String movieName) {
        this.movieName = movieName;
    }

    /**
     * function that returns a message
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * function that sets a message
     * @return
     */
    public void setMessage(final String message) {
        this.message = message;
    }
    private String message;
}
