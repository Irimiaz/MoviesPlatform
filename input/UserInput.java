package input;


public class UserInput {
    /**
     * returns users credentials
     * @return
     */
    public CreditentialsInput getCredentials() {
        return credentials;
    }

    /**
     * sets users credentials
     * @param credentials
     */
    public void setCredentials(final CreditentialsInput credentials) {
        this.credentials = credentials;
    }
    private CreditentialsInput credentials;
}
