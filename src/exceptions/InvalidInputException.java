package exceptions;

import java.util.InputMismatchException;

public class InvalidInputException extends InputMismatchException {

    public InvalidInputException() {
        super("Você digitou uma informação errada. Por favor, tente novamente.");
    }
}
