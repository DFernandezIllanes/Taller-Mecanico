package ar.com.besysoft.tallermecanico.exception.notAvailable;

public class MecanicoNotAvailableException extends EntityNotAvailableException {
    public MecanicoNotAvailableException(String message) {
        super(message);
    }

    public MecanicoNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
