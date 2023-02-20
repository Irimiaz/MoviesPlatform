package actions;

import movement.Editor;
import platform.Platform;

import java.util.Arrays;
import java.util.List;

public final class ChangePage {
    private ChangePage() { }

    /**
     * It finds if the user can change pages.
     * Every page has a array of Strings in which can be found the pages the users can navigate to
     * @param currentPage
     * @param wantedPage
     * @return
     */
    public static int change(final String currentPage, final String wantedPage) {
        int ok = 0;
        String[] homePageNotAuth = {"login", "register"};
        String[] login = {"register"};
        String[] register = {"login"};
        String[] movies = {"see details", "logout", "upgrades"};
        String[] upgrades = {"movies", "logout"};
        String[] seeDetails = {"logout", "movies", "see details"};
        String[] homePageAuth = {"movies", "upgrades", "logout"};
        List homePageNotAuthList = Arrays.asList(homePageNotAuth);
        List loginList = Arrays.asList(login);
        List registerList = Arrays.asList(register);
        List moviesList = Arrays.asList(movies);
        List upgradesList = Arrays.asList(upgrades);
        List seeDetailsList = Arrays.asList(seeDetails);
        List homePageAuthList = Arrays.asList(homePageAuth);
        if (currentPage.equals("homePageNotAuth")  && homePageNotAuthList.contains(wantedPage)) {
            Platform.getInstance().setCurrentPage(wantedPage);
            ok = 1;
        } else if (currentPage.equals("login") && loginList.contains(wantedPage)) {
            Platform.getInstance().setCurrentPage(wantedPage);
            ok = 1;
        } else if (currentPage.equals("register") && registerList.contains(wantedPage)) {
            Platform.getInstance().setCurrentPage(wantedPage);
            ok = 1;
        } else if (currentPage.equals("movies")  && moviesList.contains(wantedPage)) {
            Platform.getInstance().setCurrentPage(wantedPage);
            ok = 1;
        } else if (currentPage.equals("upgrades") && upgradesList.contains(wantedPage)) {
            Platform.getInstance().setCurrentPage(wantedPage);
            ok = 1;
        } else if (currentPage.equals("see details")  && seeDetailsList.contains(wantedPage)) {
            Platform.getInstance().setCurrentPage(wantedPage);
            ok = 1;
        } else if (currentPage.equals("homePageAuth")  && homePageAuthList.contains(wantedPage)) {
            Platform.getInstance().setCurrentPage(wantedPage);
            ok = 1;
        }
        if (wantedPage.equals("logout")) {
            Platform.getInstance().setCurrentPage("homePageNotAuth");
            Platform.getInstance().setCurrentUser(null);
            ok = 1;
            Editor.getHistory().removeAll(Editor.getHistory());
            Platform.getInstance().getMovies().removeAll(Platform.getInstance().getMovies());
            if (currentPage.equals("homePageNotAuth")) {
                ok = 0;
            }
        }

        return ok;
    }
}
