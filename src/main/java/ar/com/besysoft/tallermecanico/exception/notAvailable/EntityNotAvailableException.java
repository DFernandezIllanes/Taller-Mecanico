package ar.com.besysoft.tallermecanico.exception.notAvailable;

public abstract class EntityNotAvailableException extends RuntimeException {

    public EntityNotAvailableException(String message) {
        super(message);
    }

    public EntityNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
