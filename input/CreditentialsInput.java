package input;



public class CreditentialsInput {


    private String name;

    /**
     * returns name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * returns password
     * @return
     */
    public String getPassword() {
        return password;
    }
    /**
     * returns account type
     * @return
     */
    public String getAccountType() {
        return accountType;
    }
    /**
     * returns country
     * @return
     */
    public String getCountry() {
        return country;
    }
    /**
     * returns balance
     * @return
     */
    public int getBalance() {
        return balance;
    }

    private String password;
    private String accountType;
    private String country;
    /**
     * sets name
     * @return
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * sets password
     * @return
     */
    public void setPassword(final String password) {
        this.password = password;
    }
    /**
     * sets account type
     * @return
     */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }
    /**
     * sets country
     * @return
     */
    public void setCountry(final String country) {
        this.country = country;
    }
    /**
     * sets balance
     * @return
     */
    public void setBalance(final int balance) {
        this.balance = balance;
    }
    private int balance;
}
