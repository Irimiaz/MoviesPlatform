package platform;
import input.UserInput;
import input.CreditentialsInput;
public class UserInputToUser {
    /**
     * this function transforms a UserInput variable to a User
     * @param userInput
     * @return
     */
    public static User userInputtoUser(final UserInput userInput) {
        User user = new User(userInput.getCredentials().getName(), userInput.
                getCredentials().getPassword(), userInput.getCredentials().
                getAccountType(), userInput.getCredentials().getCountry(),
                (userInput.getCredentials().getBalance()));
        return user;
    }

    /**
     * this function transforms a User variable to a UserInput
     * @param user
     * @return
     */
    public static UserInput userToUserInput(final User user) {
        CreditentialsInput cred = new CreditentialsInput();
        cred.setName(user.getName());
        cred.setPassword(user.getPassword());
        cred.setAccountType(user.getAccountType());
        cred.setCountry(user.getCountry());
        cred.setBalance(user.getBalance());
        UserInput newUser = new UserInput();
        newUser.setCredentials(cred);
        return newUser;
    }
}
