package movement;

import java.util.LinkedList;

public class Editor {
    public static LinkedList<Command> getHistory() {
        return history;
    }

    private static LinkedList<Command> history = new LinkedList<>();

    /**
     * the function that the user uses to change page
     * @param command
     * @return
     */
    public static int move(final ChangePageCommand command) {
        if (!command.getNextPage().equals("login") && !command.getNextPage().equals("register")) {
            history.push(command);
        }
        return command.nextPage();
    }

    /**
     * the function that the user uses to back to a previous page
     * @return
     */
    public static int undo() {
        if (history.isEmpty()) {
            return 0;
        }

        Command command = history.pop();
        if (command != null) {
            return command.previousPage();

        }
        return 0;
    }
}
