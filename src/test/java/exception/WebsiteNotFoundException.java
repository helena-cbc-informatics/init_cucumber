package exception;

public class WebsiteNotFoundException extends Exception{
    public WebsiteNotFoundException(String website) {
        super("Website " + website + " is not defined.");
    }
}
