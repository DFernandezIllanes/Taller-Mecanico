package ar.com.besysoft.tallermecanico.exception.alreadyAdded;

public class ManoObraAlreadyAddedException extends EntityAlreadyAddedException {

    public ManoObraAlreadyAddedException(String message) {
        super(message);
    }

    public ManoObraAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
