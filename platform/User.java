package platform;
import observers.Notification;

import java.util.ArrayList;

public class User {
    static final int NUMBERFREEMOVIES = 15;
    private String name;
    private String password;
    private String accountType;
    private String country;
    private int balance;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies = new ArrayList<Movie>();
    private ArrayList<Movie> watchedMovies = new ArrayList<Movie>();
    private ArrayList<Movie> likedMovies = new ArrayList<Movie>();
    private ArrayList<Movie> ratedMovies = new ArrayList<Movie>();

    /**
     * this function returns all the rates of the rated genres
     * @return
     */
    public ArrayList<RatedMovie> getRates() {
        return rates;
    }
    private ArrayList<RatedMovie> rates = new ArrayList<RatedMovie>();

    /**
     * this function returns all the subscription of a certain user
     * @return
     */
    public ArrayList<String> getSubscriptions() {
        return subscriptions;
    }

    private ArrayList<String> subscriptions = new ArrayList<String>();

    /**
     * this function returns all the notification of a certain user
     * @return
     */
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    private ArrayList<Notification> notifications = new ArrayList<Notification>();
    public User(final String name, final String password,
                final String accountType, final String country, final int balance) {
        this.name = name;
        this.password = password;
        this.country = country;
        this.balance = balance;
        this.tokensCount = 0;
        this.accountType = accountType;
        this.numFreePremiumMovies = NUMBERFREEMOVIES;
    }

    /**
     * this function gets user's name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * this function sets user's name
     * @return
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * this function gets user's password
     * @return
     */
    public String getPassword() {
        return password;
    }
    /**
     * this function sets user's password
     * @return
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * this function gets user's account type
     * @return
     */
    public String getAccountType() {
        return accountType;
    }
    /**
     * this function sets user's account type
     * @return
     */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }
    /**
     * this function gets user's country
     * @return
     */
    public String getCountry() {
        return country;
    }
    /**
     * this function sets user's country
     * @return
     */
    public void setCountry(final String country) {
        this.country = country;
    }
    /**
     * this function gets user's balance
     * @return
     */
    public int getBalance() {
        return balance;
    }
    /**
     * this function sets user's balance
     * @return
     */
    public void setBalance(final int balance) {
        this.balance = balance;
    }
    /**
     * this function gets user's number of tokens
     * @return
     */
    public int getTokensCount() {
        return tokensCount;
    }
    /**
     * this function sets user's number of tokens
     * @return
     */
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }
    /**
     * this function gets user's number of free movies
     * @return
     */
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }
    /**
     * this function sets user's number of free movies
     * @return
     */
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }
    /**
     * this function gets user's purchased movies
     * @return
     */
    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }
    /**
     * this function sets user's purchased movies
     * @return
     */
    public void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    /**
     * this function gets user's watched movies
     * @return
     */
    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }
    /**
     * this function sets user's watched movies
     * @return
     */
    public void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    /**
     * this function gets user's liked movies
     * @return
     */
    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }
    /**
     * this function sets user's liked movies
     * @return
     */
    public void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }
    /**
     * this function gets user's rated movies
     * @return
     */
    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }
    /**
     * this function sets user's rated movies
     * @return
     */
    public void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
}
