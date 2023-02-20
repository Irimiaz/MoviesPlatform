package platform;

public class TopGenre {
    private String genre;

    /**
     * this funtion returns the genre of the most liked genre
     * @return
     */

    public String getGenre() {
        return genre;
    }
    /**
     * this funtion sets the genre of the most liked genre
     * @return
     */
    public void setGenre(final String genre) {
        this.genre = genre;
    }
    /**
     * this function returns the number of likes of the most liked genre
     * @return
     */
    public int getLikes() {
        return likes;
    }
    /**
     * this function sets the number of likes of the most liked genre
     * @return
     */
    public void setLikes(final int likes) {
        this.likes = likes;
    }

    private int likes;
}
