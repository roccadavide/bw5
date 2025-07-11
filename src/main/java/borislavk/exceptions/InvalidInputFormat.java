package borislavk.exceptions;

public class InvalidInputFormat extends RuntimeException {
    public InvalidInputFormat() {
        super("L'input inserito non è corretto");
    }
}
