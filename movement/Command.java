package movement;


public interface Command {
    /**
     * the interface function for next page
     * @return
     */
    int nextPage();

    /**
     * the interface function for previous page
     * @return
     */
    int previousPage();
}
