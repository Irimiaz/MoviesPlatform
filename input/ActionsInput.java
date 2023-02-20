package input;


public class ActionsInput {
    private String type;
    private String page;
    private String feature;
    private CreditentialsInput credentials;
    private String startsWith;
    private FilterInput filters;
    private int count;
    private String movie;
    private String objectType;
    public final String getType() {
        return type;
    }

    public final String getPage() {
        return page;
    }

    public final String getFeature() {
        return feature;
    }

    public final CreditentialsInput getCredentials() {
        return credentials;
    }

    public final String getStartsWith() {
        return startsWith;
    }

    public final FilterInput getFilters() {
        return filters;
    }

    public final int getCount() {
        return count;
    }

    public final String getMovie() {
        return movie;
    }

    public final String getObjectType() {
        return objectType;
    }

    public final int getRate() {
        return rate;
    }
    private int rate;

    /**
     * this function returns the genre that the user is subscribed to
     * @return
     */
    public String getSubscribedGenre() {
        return subscribedGenre;
    }
    private String subscribedGenre;

    /**
     * this function returns the movie that needs to be added
     * @return
     */
    public MoviesInput getAddedMovie() {
        return addedMovie;
    }
    private MoviesInput addedMovie;

    /**
     * this function returns the movie that needs to be deleted
     * @return
     */
    public String getDeletedMovie() {
        return deletedMovie;
    }
    private String deletedMovie;

}
