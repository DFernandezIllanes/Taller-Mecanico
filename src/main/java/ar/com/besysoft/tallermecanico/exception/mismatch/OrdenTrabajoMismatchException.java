package ar.com.besysoft.tallermecanico.exception.mismatch;

public class OrdenTrabajoMismatchException extends EntityMismatchException {
    public OrdenTrabajoMismatchException(String message) {
        super(message);
    }

    public OrdenTrabajoMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
