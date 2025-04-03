package exceptions;

public class UnrecognizedCoffeeException extends Exception {
    public UnrecognizedCoffeeException() {
        super("Unrecognized coffee type entered.");
    }
}

