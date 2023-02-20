package actions;

import input.ActionsInput;
import platform.Input;
import platform.Platform;

public class Tokens extends BasicAction {
    /**
     * If the user wants to convert his money to tokens, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        if (Platform.getInstance().getCurrentUser().getBalance() >= currentAction.getCount()
                && currentAction.getCount() > 0) {
            Platform.getInstance().getCurrentUser().setBalance(Platform.getInstance().
                    getCurrentUser().getBalance() - currentAction.getCount());
            Platform.getInstance().getCurrentUser().setTokensCount(Platform.getInstance().
                    getCurrentUser().getTokensCount() + currentAction.getCount());
        } else {
            return 0;
        }
        return 1;
    }
}
