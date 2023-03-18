package ar.com.besysoft.tallermecanico.exception.notFound;

public class VehiculoNotFoundException extends EntityNotFoundException {
    public VehiculoNotFoundException(String message) {
        super(message);
    }

    public VehiculoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
