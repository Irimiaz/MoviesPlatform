package movement;
import actions.ChangePage;
import platform.Platform;

public class ChangePageCommand implements Command {
    /**
     * returns the next page
     * @return
     */
    public String getNextPage() {
        return nextPage;
    }
    private String previousPage;
    private String nextPage;

    public ChangePageCommand(final String nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * the observer design pattern function which changes pages
     * @return
     */
    @Override
    public int nextPage() {
        previousPage = Platform.getInstance().getCurrentPage();
        return ChangePage.change(previousPage, nextPage);
    }

    /**
     * the observer design pattern function which undo the previous function
     * @return
     */
    @Override
    public int previousPage() {
        nextPage = previousPage;
        previousPage = Platform.getInstance().getCurrentPage();
        Platform.getInstance().setCurrentPage(nextPage);
        return 1;
    }
}
