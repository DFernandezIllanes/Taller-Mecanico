package ar.com.besysoft.tallermecanico.exception.mismatch;

public abstract class EntityMismatchException extends RuntimeException {

    public EntityMismatchException(String message) {
        super(message);
    }

    public EntityMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
