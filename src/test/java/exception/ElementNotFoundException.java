package exception;

public class ElementNotFoundException extends Exception{
    public ElementNotFoundException(String locator) {
        super("Element with locator " + locator + " is not found.");
    }
}
