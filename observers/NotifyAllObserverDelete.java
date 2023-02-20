package observers;

import platform.Platform;
import platform.User;

public class NotifyAllObserverDelete extends Observer {
    /**
     * this function notifies all the observers that the subject has changed
     * (a new subscribed genre has to be deleted)
     * @param subject
     */
    public NotifyAllObserverDelete(final Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    /**
     * the observer is update and it creates and sends a notification to the user
     */
    @Override
    public void update() {
        Notification notification = new Notification();
        notification.setMessage("DELETE");
        notification.setMovieName(subject.getMovie().getName());
        for (User user: Platform.getInstance().getAllUsers()) {
            for (String genre : subject.getMovie().getGenres()) {
                if (user.getSubscriptions().contains(genre) && !subject.getMovie().
                        getCountriesBanned().contains(user.getCountry())) {
                    user.getNotifications().add(notification);
                }
            }
        }
    }
}
