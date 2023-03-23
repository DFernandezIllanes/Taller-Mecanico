package ar.com.besysoft.tallermecanico.exception.repeat;

public abstract class EntityRepeatException extends RuntimeException {

    public EntityRepeatException(String message) {
        super(message);
    }

    public EntityRepeatException(String message, Throwable cause) {
        super(message, cause);
    }
}
