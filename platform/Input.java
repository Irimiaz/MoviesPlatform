package platform;

import input.UserInput;
import input.MoviesInput;
import input.ActionsInput;

import java.util.ArrayList;

public final class Input {
    /**
     * this returns all the available users
     * @return
     */
    public ArrayList<UserInput> getUsers() {
        return users;
    }
    /**
     * this returns all the available movies
     * @return
     */
    public ArrayList<MoviesInput> getMovies() {
        return movies;
    }
    /**
     * this returns all the actions that users do
     * @return
     */
    public ArrayList<ActionsInput> getActions() {
        return actions;
    }
    private ArrayList<UserInput> users = new ArrayList<UserInput>();
    private ArrayList<MoviesInput> movies = new ArrayList<MoviesInput>();
    private ArrayList<ActionsInput> actions = new ArrayList<ActionsInput>();
}

