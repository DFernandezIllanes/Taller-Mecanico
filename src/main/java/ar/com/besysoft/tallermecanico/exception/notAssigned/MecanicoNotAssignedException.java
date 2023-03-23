package ar.com.besysoft.tallermecanico.exception.notAssigned;

public class MecanicoNotAssignedException extends EntityNotAssignedException {
    public MecanicoNotAssignedException(String message) {
        super(message);
    }

    public MecanicoNotAssignedException(String message, Throwable cause) {
        super(message, cause);
    }
}
