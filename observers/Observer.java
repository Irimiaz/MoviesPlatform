package observers;

public abstract class Observer {
    protected Subject subject;

    /**
     * the interface for the function that updates all the observers
     */
    public abstract void update();
}
