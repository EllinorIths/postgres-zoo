package se.iths.cecilia.postrgreszoo.exception.monkeyexceptions;

public class MonkeyNameIsEmptyException extends RuntimeException {
    public MonkeyNameIsEmptyException(String message) {
        super(message);
    }
}
