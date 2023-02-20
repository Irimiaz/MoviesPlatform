package actions;

import input.ActionsInput;
import input.UserInput;
import platform.Platform;
import platform.Input;
import platform.User;
import platform.UserInputToUser;
public class Login extends BasicAction {
    /**
     * If the user wants to login, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        int ok = 0;
        int ok1 = 0;
        int ok2 = 0;
        for (UserInput user : input.getUsers()) {
            User addUser = UserInputToUser.userInputtoUser(user);
            for (User availableUser: Platform.getInstance().getAllUsers()) {
                if (availableUser.getName().equals(addUser.getName())) {
                    ok2 = 1;
                }
            }
            if (ok2 == 0) {
                Platform.getInstance().getAllUsers().add(addUser);
            }
            if (user.getCredentials().getName().equals(currentAction.getCredentials().getName())
                    && user.getCredentials().getPassword()
                    .equals(currentAction.getCredentials().getPassword())) {
                ok = 1;
                for (User availableUser: Platform.getInstance().getAllUsers()) {
                    if (availableUser.getName().equals(user.getCredentials().getName())) {
                        Platform.getInstance().setCurrentUser(availableUser);
                        ok1 = 1;
                    }
                }
                if (ok1 == 0) {
                    User newUser = UserInputToUser.userInputtoUser(user);
                    Platform.getInstance().setCurrentUser(newUser);
                }
                Platform.getInstance().setCurrentPage("homePageAuth");

            }
        }
        if (ok == 0) {
            Platform.getInstance().setCurrentPage("homePageNotAuth");
        }
        return ok;
    }
}
