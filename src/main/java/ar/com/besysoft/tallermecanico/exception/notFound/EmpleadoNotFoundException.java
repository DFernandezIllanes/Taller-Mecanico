package ar.com.besysoft.tallermecanico.exception.notFound;

public class EmpleadoNotFoundException extends EntityNotFoundException {

    public EmpleadoNotFoundException(String message) {
        super(message);
    }

    public EmpleadoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
