package exception;

public class CouldNotCreateDriverException extends Exception{
    public CouldNotCreateDriverException(Exception e) {
        super("It was not possible to create a driver: " + e.getMessage());
    }
}
