package observers;

import platform.Platform;
import platform.User;

public class RemoveMovie extends Observer {
    public RemoveMovie(final Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * this function is used when an observer is updated and needs to delete a certain
     * movie from all the users' databases
     */
    @Override
    public void update() {
        if (Platform.getPlatform().getAllMovies().contains(subject.getMovie())) {
            Platform.getPlatform().getAllMovies().remove(subject.getMovie());
        }
        for (User user: Platform.getInstance().getAllUsers()) {
            if (user.getPurchasedMovies().contains(subject.getMovie())) {
                user.getPurchasedMovies().remove(subject.getMovie());
                if (user.getAccountType().equals("standard")) {
                    user.setTokensCount(user.getTokensCount() + 2);
                } else {
                    user.setNumFreePremiumMovies(user.getNumFreePremiumMovies() + 1);
                }
            }
            if (user.getWatchedMovies().contains(subject.getMovie())) {
                user.getWatchedMovies().remove(subject.getMovie());
            }
            if (user.getLikedMovies().contains(subject.getMovie())) {
                user.getLikedMovies().remove(subject.getMovie());
            }
            if (user.getRatedMovies().contains(subject.getMovie())) {
                user.getRatedMovies().remove(subject.getMovie());
            }

        }
    }
}
