package observers;

import platform.Platform;
import platform.User;

public class NotifyAllObserverAdd extends Observer {
    /**
     * this function notifies all the observers that the subject has changed
     * (a new subscribed genre has been added)
     * @param subject
     */
    public NotifyAllObserverAdd(final Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * the observer is update and it creates and sends a notification to the user
     */
    @Override
    public void update() {
        Platform.getInstance().getAllMovies().add(subject.getMovie());
        Notification notification = new Notification();
        notification.setMessage("ADD");
        notification.setMovieName(subject.getMovie().getName());
        for (User user: Platform.getInstance().getAllUsers()) {
            for (String genre : subject.getMovie().getGenres()) {
                if (user.getSubscriptions().contains(genre) && !subject.getMovie().
                        getCountriesBanned().contains(user.getCountry())) {
                    if (!user.getNotifications().contains(notification)) {
                        user.getNotifications().add(notification);
                    }
                }
            }
        }
    }
}
