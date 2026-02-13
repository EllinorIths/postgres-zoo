package se.iths.cecilia.postrgreszoo.exception.monkeyexceptions;

public class MonkeyNotFoundException extends RuntimeException {
    public MonkeyNotFoundException(String message) {
        super(message);
    }
}
