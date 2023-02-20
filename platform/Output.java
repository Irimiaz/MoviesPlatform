package platform;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import observers.Notification;

public class Output {
    /**
     * this function displays a basic error which appears when a action is impossible
     * @param output
     */
    public static void errorOutput(final ArrayNode output) {
        ObjectNode newNode = output.addObject();
        newNode.put("error", "Error");
        ArrayNode newArrayNode1 = newNode.putArray("currentMoviesList");
        newNode.putNull("currentUser");

    }

    /**
     * this function displays a searched movie and the basic information of the current user
     * @param output
     * @param name
     */
    public static void movieOutput(final ArrayNode output, final String name) {
        ObjectNode newNode = output.addObject();
        newNode.putNull("error");
        ArrayNode newArrayNode1 = newNode.putArray("currentMoviesList");
        for (Movie movie: Platform.getInstance().getMovies()) {
            if (movie.getName().equals(name)) {
                ObjectNode movieNode = newArrayNode1.addObject();
                movieNode.put("name", movie.getName());
                movieNode.put("year", movie.getYear());
                movieNode.put("duration", movie.getDuration());
                ArrayNode genresArray = movieNode.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode actorsArray = movieNode.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode bannedArray = movieNode.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                movieNode.put("numLikes", movie.getNumLikes());
                movieNode.put("rating", movie.getRating());
                movieNode.put("numRatings", movie.getNumRatings());
            }
        }
        ObjectNode userNode = newNode.putObject("currentUser");
        ObjectNode credNode = userNode.putObject("credentials");
        if (Platform.getInstance().getCurrentUser() != null) {
            credNode.put("name", Platform.getInstance().getCurrentUser().getName());
            credNode.put("password", Platform.getInstance().getCurrentUser().getPassword());
            credNode.put("accountType", Platform.getInstance().getCurrentUser().getAccountType());
            credNode.put("country", Platform.getInstance().getCurrentUser().getCountry());
            credNode.put("balance", Integer.valueOf(Platform.getInstance().getCurrentUser().
                    getBalance()).toString());
            userNode.put("tokensCount", Platform.getInstance().getCurrentUser().getTokensCount());
            userNode.put("numFreePremiumMovies", Platform.getInstance().getCurrentUser().
                    getNumFreePremiumMovies());
            ArrayNode purchNodes = userNode.putArray("purchasedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getPurchasedMovies()) {
                ObjectNode purchNode = purchNodes.addObject();
                purchNode.put("name", movie.getName());
                purchNode.put("year", movie.getYear());
                purchNode.put("duration", movie.getDuration());
                ArrayNode actorsArray = purchNode.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = purchNode.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = purchNode.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                purchNode.put("numLikes", movie.getNumLikes());
                purchNode.put("rating", movie.getRating());
                purchNode.put("numRatings", movie.getNumRatings());
            }

            ArrayNode ratedNodes = userNode.putArray("ratedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getRatedMovies()) {
                ObjectNode ratedNode = ratedNodes.addObject();
                ratedNode.put("name", movie.getName());
                ratedNode.put("year", movie.getYear());
                ratedNode.put("duration", movie.getDuration());
                ArrayNode actorsArray = ratedNode.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = ratedNode.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = ratedNode.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                ratedNode.put("numLikes", movie.getNumLikes());
                ratedNode.put("rating", movie.getRating());
                ratedNode.put("numRatings", movie.getNumRatings());
            }
            ArrayNode watchMovies = userNode.putArray("watchedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getWatchedMovies()) {
                ObjectNode watchMovie = watchMovies.addObject();
                watchMovie.put("name", movie.getName());
                watchMovie.put("year", movie.getYear());
                watchMovie.put("duration", movie.getDuration());
                ArrayNode actorsArray = watchMovie.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = watchMovie.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = watchMovie.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                watchMovie.put("numLikes", movie.getNumLikes());
                watchMovie.put("rating", movie.getRating());
                watchMovie.put("numRatings", movie.getNumRatings());
            }
            ArrayNode likedMovies = userNode.putArray("likedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getLikedMovies()) {
                ObjectNode likedMovie = likedMovies.addObject();
                likedMovie.put("name", movie.getName());
                likedMovie.put("year", movie.getYear());
                likedMovie.put("duration", movie.getDuration());
                ArrayNode actorsArray = likedMovie.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = likedMovie.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = likedMovie.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                likedMovie.put("numLikes", movie.getNumLikes());
                likedMovie.put("rating", movie.getRating());
                likedMovie.put("numRatings", movie.getNumRatings());
            }
            ArrayNode notifications = userNode.putArray("notifications");
            for (Notification notification : Platform.getInstance().getCurrentUser()
                    .getNotifications()) {
                ObjectNode notifNode = notifications.addObject();
                notifNode.put("movieName", notification.getMovieName());
                notifNode.put("message", notification.getMessage());
            }
        }
    }

    /**
     * this function is the main display funcion
     * this displays all the available movies, the current user and his credentials
     * and all the liked, watched, rated and purchased movies by the user
     * @param output
     */
    public static void nullOutput(final ArrayNode output) {
        ObjectNode newNode = output.addObject();
        newNode.putNull("error");
        ArrayNode newArrayNode1 = newNode.putArray("currentMoviesList");
        for (Movie movie: Platform.getInstance().getMovies()) {
            ObjectNode movieNode = newArrayNode1.addObject();
            movieNode.put("name", movie.getName());
            movieNode.put("year", movie.getYear());
            movieNode.put("duration", movie.getDuration());
            ArrayNode genresArray = movieNode.putArray("genres");
            for (String genre : movie.getGenres()) {
                genresArray.add(genre);
            }
            ArrayNode actorsArray = movieNode.putArray("actors");
            for (String actor : movie.getActors()) {
                actorsArray.add(actor);
            }
            ArrayNode bannedArray = movieNode.putArray("countriesBanned");
            for (String countryBanned : movie.getCountriesBanned()) {
                bannedArray.add(countryBanned);
            }
            movieNode.put("numLikes", movie.getNumLikes());
            movieNode.put("rating", movie.getRating());
            movieNode.put("numRatings", movie.getNumRatings());
        }
        ObjectNode userNode = newNode.putObject("currentUser");
        ObjectNode credNode = userNode.putObject("credentials");
        if (Platform.getInstance().getCurrentUser() != null) {
            credNode.put("name", Platform.getInstance().getCurrentUser().getName());
            credNode.put("password", Platform.getInstance().getCurrentUser().getPassword());
            credNode.put("accountType", Platform.getInstance().getCurrentUser().getAccountType());
            credNode.put("country", Platform.getInstance().getCurrentUser().getCountry());
            credNode.put("balance", Integer.valueOf(Platform.getInstance().getCurrentUser().
                    getBalance()).toString());
            userNode.put("tokensCount", Platform.getInstance().getCurrentUser().getTokensCount());
            userNode.put("numFreePremiumMovies", Platform.getInstance().getCurrentUser()
                    .getNumFreePremiumMovies());
            ArrayNode purchNodes = userNode.putArray("purchasedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getPurchasedMovies()) {
                ObjectNode purchNode = purchNodes.addObject();
                purchNode.put("name", movie.getName());
                purchNode.put("year", movie.getYear());
                purchNode.put("duration", movie.getDuration());
                ArrayNode actorsArray = purchNode.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = purchNode.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = purchNode.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                purchNode.put("numLikes", movie.getNumLikes());
                purchNode.put("rating", movie.getRating());
                purchNode.put("numRatings", movie.getNumRatings());
            }
            ArrayNode ratedNodes = userNode.putArray("ratedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getRatedMovies()) {
                ObjectNode ratedNode = ratedNodes.addObject();
                ratedNode.put("name", movie.getName());
                ratedNode.put("year", movie.getYear());
                ratedNode.put("duration", movie.getDuration());
                ArrayNode actorsArray = ratedNode.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = ratedNode.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = ratedNode.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                ratedNode.put("numLikes", movie.getNumLikes());
                ratedNode.put("rating", movie.getRating());
                ratedNode.put("numRatings", movie.getNumRatings());
            }
            ArrayNode watchMovies = userNode.putArray("watchedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getWatchedMovies()) {
                ObjectNode watchMovie = watchMovies.addObject();
                watchMovie.put("name", movie.getName());
                watchMovie.put("year", movie.getYear());
                watchMovie.put("duration", movie.getDuration());
                ArrayNode actorsArray = watchMovie.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = watchMovie.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = watchMovie.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                watchMovie.put("numLikes", movie.getNumLikes());
                watchMovie.put("rating", movie.getRating());
                watchMovie.put("numRatings", movie.getNumRatings());
            }
            ArrayNode likedMovies = userNode.putArray("likedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getLikedMovies()) {
                ObjectNode likedMovie = likedMovies.addObject();
                likedMovie.put("name", movie.getName());
                likedMovie.put("year", movie.getYear());
                likedMovie.put("duration", movie.getDuration());
                ArrayNode actorsArray = likedMovie.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = likedMovie.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = likedMovie.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                likedMovie.put("numLikes", movie.getNumLikes());
                likedMovie.put("rating", movie.getRating());
                likedMovie.put("numRatings", movie.getNumRatings());
            }
            ArrayNode notifications = userNode.putArray("notifications");
            for (Notification notification : Platform.getInstance().getCurrentUser().
                    getNotifications()) {
                ObjectNode notifNode = notifications.addObject();
                notifNode.put("movieName", notification.getMovieName());
                notifNode.put("message", notification.getMessage());
            }
        }
    }

    /**
     * this display function is used at the end of a test in order to display the
     * current user and the recommendation notification
     * @param output
     */
    public static void lastOutput(final ArrayNode output) {
        ObjectNode newNode = output.addObject();
        newNode.putNull("error");
        newNode.putNull("currentMoviesList");
        ObjectNode userNode = newNode.putObject("currentUser");
        ObjectNode credNode = userNode.putObject("credentials");
        if (Platform.getInstance().getCurrentUser() != null) {
            credNode.put("name", Platform.getInstance().getCurrentUser().getName());
            credNode.put("password", Platform.getInstance().getCurrentUser().getPassword());
            credNode.put("accountType", Platform.getInstance().getCurrentUser().getAccountType());
            credNode.put("country", Platform.getInstance().getCurrentUser().getCountry());
            credNode.put("balance", Integer.valueOf(Platform.getInstance().getCurrentUser().
                    getBalance()).toString());
            userNode.put("tokensCount", Platform.getInstance().getCurrentUser().getTokensCount());
            userNode.put("numFreePremiumMovies", Platform.getInstance().getCurrentUser().
                    getNumFreePremiumMovies());
            ArrayNode purchNodes = userNode.putArray("purchasedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getPurchasedMovies()) {
                ObjectNode purchNode = purchNodes.addObject();
                purchNode.put("name", movie.getName());
                purchNode.put("year", movie.getYear());
                purchNode.put("duration", movie.getDuration());
                ArrayNode actorsArray = purchNode.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = purchNode.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = purchNode.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                purchNode.put("numLikes", movie.getNumLikes());
                purchNode.put("rating", movie.getRating());
                purchNode.put("numRatings", movie.getNumRatings());
            }

            ArrayNode ratedNodes = userNode.putArray("ratedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getRatedMovies()) {
                ObjectNode ratedNode = ratedNodes.addObject();
                ratedNode.put("name", movie.getName());
                ratedNode.put("year", movie.getYear());
                ratedNode.put("duration", movie.getDuration());
                ArrayNode actorsArray = ratedNode.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = ratedNode.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = ratedNode.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                ratedNode.put("numLikes", movie.getNumLikes());
                ratedNode.put("rating", movie.getRating());
                ratedNode.put("numRatings", movie.getNumRatings());
            }
            ArrayNode watchMovies = userNode.putArray("watchedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getWatchedMovies()) {
                ObjectNode watchMovie = watchMovies.addObject();
                watchMovie.put("name", movie.getName());
                watchMovie.put("year", movie.getYear());
                watchMovie.put("duration", movie.getDuration());
                ArrayNode actorsArray = watchMovie.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = watchMovie.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = watchMovie.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                watchMovie.put("numLikes", movie.getNumLikes());
                watchMovie.put("rating", movie.getRating());
                watchMovie.put("numRatings", movie.getNumRatings());
            }
            ArrayNode likedMovies = userNode.putArray("likedMovies");
            for (Movie movie : Platform.getInstance().getCurrentUser().getLikedMovies()) {
                ObjectNode likedMovie = likedMovies.addObject();
                likedMovie.put("name", movie.getName());
                likedMovie.put("year", movie.getYear());
                likedMovie.put("duration", movie.getDuration());
                ArrayNode actorsArray = likedMovie.putArray("actors");
                for (String actor : movie.getActors()) {
                    actorsArray.add(actor);
                }
                ArrayNode genresArray = likedMovie.putArray("genres");
                for (String genre : movie.getGenres()) {
                    genresArray.add(genre);
                }
                ArrayNode bannedArray = likedMovie.putArray("countriesBanned");
                for (String countryBanned : movie.getCountriesBanned()) {
                    bannedArray.add(countryBanned);
                }
                likedMovie.put("numLikes", movie.getNumLikes());
                likedMovie.put("rating", movie.getRating());
                likedMovie.put("numRatings", movie.getNumRatings());
            }
            ArrayNode notifications = userNode.putArray("notifications");
            for (Notification notification : Platform.getInstance().getCurrentUser().
                    getNotifications()) {
                ObjectNode notifNode = notifications.addObject();
                notifNode.put("movieName", notification.getMovieName());
                notifNode.put("message", notification.getMessage());
            }
        }
    }
}
