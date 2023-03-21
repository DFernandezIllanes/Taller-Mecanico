package ar.com.besysoft.tallermecanico.exception.notFound;

public class OrdenTrabajoNotFoundException extends EntityNotFoundException {
    public OrdenTrabajoNotFoundException(String message) {
        super(message);
    }

    public OrdenTrabajoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
