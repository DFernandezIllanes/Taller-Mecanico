package ar.com.besysoft.tallermecanico.exception.repeat;

public class RepuestoRepeatException extends EntityRepeatException {
    public RepuestoRepeatException(String message) {
        super(message);
    }

    public RepuestoRepeatException(String message, Throwable cause) {
        super(message, cause);
    }
}
