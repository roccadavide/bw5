package daviderocca.exceptions;

public class InvalidUUIDFormat  extends RuntimeException {
    public InvalidUUIDFormat(String id) {
        super("il formato codice " + id + " non è valido");
    }
}
