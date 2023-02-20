package actions;

import input.ActionsInput;
import platform.Input;
import platform.Platform;


public class Premium extends BasicAction {
    static final int  PREMIUMACCOUNTCOST = 10;
    /**
     * If the user wants to buy a Premium account, he uses this function
     * @param currentAction
     * @param input
     * @return
     */
    public int action(final ActionsInput currentAction, final Input input) {
        if (Platform.getInstance().getCurrentUser().getTokensCount() >= PREMIUMACCOUNTCOST) {
            Platform.getInstance().getCurrentUser().
                    setTokensCount(Platform.getInstance().
                            getCurrentUser().getTokensCount() - PREMIUMACCOUNTCOST);
            Platform.getInstance().getCurrentUser().setAccountType("premium");
        } else {
            return 0;
        }
        return 1;
    }
}
