
import actions.Recommend;
import movement.ChangePageCommand;
import movement.Editor;
import platform.Platform;
import platform.Movie;
import platform.Input;
import platform.MovieInputToUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;
import java.io.IOException;
import platform.Output;

import actions.ActionFactory;
import input.ActionsInput;
import input.MoviesInput;

public class Main {
    private static int a = 0;

    /**
     * this is the brain of the database.
     * It takes input commands and gives the users the desired outputs
     * @param argv
     * @throws IOException
     */
    public static void main(final String[] argv) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode output = objectMapper.createArrayNode();
        a++;
        Input inputData = objectMapper.readValue(new File(argv[0]), Input.class);

        Platform.getInstance().setCurrentPage("homePageNotAuth");

            /////////////////////////////////////
            for (MoviesInput movie : inputData.getMovies()) {
                Movie newMovie = MovieInputToUser.movieInputToMovie(movie);
                Platform.getInstance().getDatabase().databaseAdd(newMovie);
            }


            for (ActionsInput currentAction : inputData.getActions()) {
                if (currentAction.getType().equals("database")) {
                    if (currentAction.getFeature().equals("add")) {
                        Movie movie = MovieInputToUser.movieInputToMovie(currentAction.
                                getAddedMovie());
                        if (Platform.getInstance().getDatabase().databaseAdd(movie) == 0) {
                            Output.errorOutput(output);
                        }
                    }
                    if (currentAction.getFeature().equals("delete")) {
                        int ok = 0;
                        for (Movie movie : Platform.getInstance().getDatabase().getMovies()) {
                            if (movie.getName().equals(currentAction.getDeletedMovie())) {
                                Platform.getInstance().getDatabase().databaseDelete(movie);
                                ok = 1;
                                break;
                            }
                        }
                        if (ok == 0) {
                            Output.errorOutput(output);
                        }
                    }
                } else if (currentAction.getType().equals("back")) {
                    if (Editor.undo() == 0) {
                        Output.errorOutput(output);
                    }
                    if (Platform.getInstance().getCurrentPage().equals("movies")) {
                        Output.nullOutput(output);
                    }
                } else if (currentAction.getType().equals("change page")) {
                    ChangePageCommand command = new ChangePageCommand(currentAction.getPage());
                    if (Editor.move(command) == 0) {
                        Output.errorOutput(output);
                        Editor.undo();
                    } else {
                        if (currentAction.getPage().equals("movies")) {
                            if (Platform.getInstance().getAllMovies().size() == 0) {
                                for (MoviesInput movie : inputData.getMovies()) {
                                    Movie newMovie = MovieInputToUser.movieInputToMovie(movie);
                                    int ok = 1;
                                    for (Movie currentMovie : Platform.getInstance().
                                            getAllMovies()) {
                                        if (currentMovie.getName().equals(newMovie.getName())) {
                                            ok = 0;
                                        }
                                    }
                                    if (ok == 1) {
                                        Platform.getInstance().getAllMovies().add(newMovie);
                                    }
                                }
                            }
                            for (Movie movie : Platform.getInstance().getAllMovies()) {
                                if (!movie.getCountriesBanned().contains(Platform.getInstance().
                                        getCurrentUser().getCountry())) {
                                    int ok = 1;
                                    for (Movie currentMovie : Platform.getInstance().getMovies()) {
                                        if (currentMovie.getName().equals(movie.getName())) {
                                            ok = 0;
                                        }
                                    }
                                    if (ok == 1) {
                                        Platform.getInstance().getMovies().add(movie);
                                    }
                                }
                            }
                        Output.nullOutput(output);
                        }
                    }
                    if (Platform.getInstance().getCurrentPage().equals("see details")) {
                        int ok = 0;
                        for (Movie movie : Platform.getInstance().getMovies()) {
                            if (movie.getName().equals(currentAction.getMovie())) {
                                ok = 1;
                            }
                        }
                        if (ok == 1) {
                            Platform.getInstance().setSeeDetailsMovie(currentAction.getMovie());
                            Output.movieOutput(output, currentAction.getMovie());
                        } else {
                            //Output.errorOutput(output);
                            Output.errorOutput(output);
                            Editor.undo();
                        }
                    }
                } else if (currentAction.getType().equals("on page")) {
                    if (currentAction.getFeature().equals("subscribe")) {
                        if (ActionFactory.doAction("subscribe").
                                action(currentAction, inputData) == 0) {
                            Output.errorOutput(output);
                        }
                    } else if (currentAction.getFeature().equals("login")) {
                        if (!Platform.getInstance().getCurrentPage().equals("login") || ActionFactory.doAction("login").action(currentAction, inputData) == 0) {
                            Output.errorOutput(output);
                            if (Platform.getInstance().getCurrentUser() == null) {
                                Platform.getInstance().setCurrentPage("homePageNotAuth");
                            }
                        } else {
                            Output.nullOutput(output);
                            Platform.getInstance().setCurrentPage("homePageAuth");
                        }
                    } else if (currentAction.getFeature().equals("register")) {
                        if (!Platform.getInstance().getCurrentPage().equals("register") || ActionFactory.doAction("register").action(currentAction, inputData) == 0) {
                            Output.errorOutput(output);
                            Platform.getInstance().setCurrentPage("homePageNotAuth");
                        } else {
                            ActionFactory.doAction("login").
                                    action(currentAction, inputData);
                            Platform.getInstance().setCurrentPage("homePageAuth");
                            Output.nullOutput(output);
                        }


                    } else if (currentAction.getFeature().equals("search")) {
                        if (!Platform.getInstance().getCurrentPage().equals("movies")) {
                            Output.errorOutput(output);
                        } else {
                            ActionFactory.doAction("search").action(currentAction, inputData);
                            Output.nullOutput(output);
                            Platform.getPlatform().getMovies().removeAll(Platform.getPlatform().getMovies());
                            Platform.getPlatform().getMovies().addAll(Platform.getPlatform().getSearchedMovies());
                            Platform.getPlatform().getSearchedMovies().removeAll(Platform.getPlatform().getSearchedMovies());
                        }
                    } else if (currentAction.getFeature().equals("filter")) {
                        if (!Platform.getInstance().getCurrentPage().equals("movies")) {
                            Output.errorOutput(output);
                        } else {
                            if (Platform.getInstance().getBeforeFiltered().size() == 0) {
                                Platform.getInstance().getBeforeFiltered().
                                        addAll(Platform.getInstance().getMovies());
                            } else {
                                Platform.getInstance().getMovies().
                                        removeAll(Platform.getInstance().getAllMovies());
                                Platform.getInstance().getMovies().
                                        addAll(Platform.getInstance().getBeforeFiltered());
                            }
                            ActionFactory.doAction("filter").action(currentAction, inputData);
                            Output.nullOutput(output);

                        }
                    } else if (currentAction.getFeature().equals("buy tokens")) {
                        if (!Platform.getInstance().getCurrentPage().equals("upgrades")) {
                            Output.errorOutput(output);
                        } else {
                            if (ActionFactory.doAction("buy tokens").action(currentAction, inputData) == 0) {
                                Output.errorOutput(output);
                            }

                        }
                    } else if (currentAction.getFeature().equals("buy premium account")) {
                        if (!Platform.getInstance().getCurrentPage().equals("upgrades")) {
                            Output.errorOutput(output);
                        } else {
                            if (ActionFactory.doAction("buy premium account").action(currentAction, inputData) == 0) {
                                Output.errorOutput(output);
                            }
                        }
                    } else if (currentAction.getFeature().equals("purchase")) {
                        if (!Platform.getInstance().getCurrentPage().equals("see details")) {
                            Output.errorOutput(output);
                        } else {
                            if (ActionFactory.doAction("purchase").action(currentAction, inputData) == 0) {
                                Output.errorOutput(output);
                            } else {
                                Output.movieOutput(output, Platform.getInstance().getSeeDetailsMovie());
                            }
                        }
                    } else if (currentAction.getFeature().equals("watch")) {
                        if (!Platform.getInstance().getCurrentPage().equals("see details")) {
                            Output.errorOutput(output);
                        } else {
                            if (ActionFactory.doAction("watch").action(currentAction, inputData) == 0) {
                                Output.errorOutput(output);
                            } else {
                                Output.movieOutput(output, Platform.getPlatform().getSeeDetailsMovie());
                            }
                        }
                    } else if (currentAction.getFeature().equals("like")) {
                        if (!Platform.getInstance().getCurrentPage().equals("see details")) {
                            Output.errorOutput(output);
                        } else {
                            if (ActionFactory.doAction("like").action(currentAction, inputData) == 0) {
                                Output.errorOutput(output);
                            } else {
                                Output.movieOutput(output, Platform.getPlatform().getSeeDetailsMovie());
                            }
                        }
                    } else if (currentAction.getFeature().equals("rate")) {
                        if (!Platform.getInstance().getCurrentPage().equals("see details")) {
                            Output.errorOutput(output);
                        } else {
                            if (ActionFactory.doAction("rate").action(currentAction, inputData) == 0) {
                                Output.errorOutput(output);
                            } else {
                                Output.movieOutput(output, Platform.getPlatform().getSeeDetailsMovie());
                            }
                        }
                    }
                }

        }
        if (Recommend.action() == 1) {
            Output.lastOutput(output);
        }
        Editor.getHistory().removeAll(Editor.getHistory());

            /////////////////////////////////////
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(argv[1]), output);
        Platform.removeInstance();
    }
}
