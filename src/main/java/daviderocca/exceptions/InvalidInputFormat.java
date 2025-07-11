package daviderocca.exceptions;

public class InvalidInputFormat extends RuntimeException {
    public InvalidInputFormat() {
        super("L'input inserito non è corretto");
    }
}
