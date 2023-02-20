package actions;

import input.ActionsInput;
import platform.Input;
public abstract class BasicAction {
    /**
     * Part of the Factory design Pattern
     * It is the function that every class has
     */
    public abstract int action(ActionsInput currentAction, Input input);
}
