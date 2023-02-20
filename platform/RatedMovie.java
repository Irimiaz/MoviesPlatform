package platform;

public class RatedMovie {

    /**
     * this function returns the name of the rated movie
     * @return
     */
    public Movie getMovie() {
        return movie;
    }
    /**
     * this function sets the name of the rated movie
     * @return
     */
    public void setMovie(final Movie movie) {
        this.movie = movie;
    }
    /**
     * this function returns the rate of the rated movie
     * @return
     */
    public int getRate() {
        return rate;
    }
    /**
     * this function sets the rate of the rated movie
     * @return
     */
    public void setRate(final int rate) {
        this.rate = rate;
    }

    private Movie movie;
    private int rate;
}
