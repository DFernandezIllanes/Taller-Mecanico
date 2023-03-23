package ar.com.besysoft.tallermecanico.exception.notFound;

public class RepuestoNotFoundException extends EntityNotFoundException {
    public RepuestoNotFoundException(String message) {
        super(message);
    }

    public RepuestoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
