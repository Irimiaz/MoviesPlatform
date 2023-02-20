package actions;


import input.ActionsInput;
import input.UserInput;
import platform.Input;
import platform.Platform;
import platform.User;
import platform.UserInputToUser;

public class Register extends BasicAction {
    /**
     * If the user wants to register, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        User user = new User(currentAction.getCredentials().getName(), currentAction.
                getCredentials().getPassword(), currentAction.getCredentials().
                getAccountType(), currentAction.getCredentials().getCountry(),
                currentAction.getCredentials().getBalance());
        UserInput newUser = UserInputToUser.userToUserInput(user);
        if (input.getUsers().contains(newUser)) {
            return 0;
        }
        input.getUsers().add(newUser);
        Platform.getInstance().getAllUsers().add(user);
        return 1;
    }
}
