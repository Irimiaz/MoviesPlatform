package actions;

public final class ActionFactory {
    private ActionFactory() { }
    /**
        Factory Design Pattern
     */
    public static BasicAction doAction(final String feature) {
        switch (feature) {
            case "register": return new Register();
            case "login": return new Login();
            case "search": return new Search();
            case "filter": return new Filter();
            case "buy tokens": return new Tokens();
            case "buy premium account": return new Premium();
            case "purchase": return new Purchase();
            case "watch": return new Watch();
            case "like": return new Like();
            case "rate": return new Rate();
            case "subscribe": return new Subscribe();
            default: throw new IllegalArgumentException("Action name is wrong!");
        }
    }
}
