package ar.com.besysoft.tallermecanico.exception.mismatch;

public class ClienteMismatchException extends EntityMismatchException {

    public ClienteMismatchException(String message) {
        super(message);
    }

    public ClienteMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
