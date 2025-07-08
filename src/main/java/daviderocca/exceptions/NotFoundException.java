package daviderocca.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Il punto vendita con id " + id + " non è stato trovato!");
    }
}
