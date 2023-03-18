package ar.com.besysoft.tallermecanico.exception.alreadyAdded;

public class VehiculoAlreadyAddedException extends EntityAlreadyAddedException {
    public VehiculoAlreadyAddedException(String message) {
        super(message);
    }

    public VehiculoAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
