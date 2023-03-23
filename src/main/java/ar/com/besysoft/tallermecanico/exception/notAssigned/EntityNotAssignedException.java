package ar.com.besysoft.tallermecanico.exception.notAssigned;

public abstract class EntityNotAssignedException extends RuntimeException {

    public EntityNotAssignedException(String message){
        super(message);
    }

    public EntityNotAssignedException(String message, Throwable cause) {

    }
}
