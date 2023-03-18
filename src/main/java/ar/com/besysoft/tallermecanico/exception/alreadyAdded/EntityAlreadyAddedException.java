package ar.com.besysoft.tallermecanico.exception.alreadyAdded;

public abstract class EntityAlreadyAddedException extends RuntimeException {

    public EntityAlreadyAddedException(String message) {
        super(message);
    }

    public EntityAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
