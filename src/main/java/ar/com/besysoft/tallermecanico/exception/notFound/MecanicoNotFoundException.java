package ar.com.besysoft.tallermecanico.exception.notFound;

public class MecanicoNotFoundException extends EntityNotFoundException {
    public MecanicoNotFoundException(String message) {
        super(message);
    }

    public MecanicoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
