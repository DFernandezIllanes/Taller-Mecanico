package ar.com.besysoft.tallermecanico.exception.notFound;

public class ManoObraNotFoundException extends EntityNotFoundException {
    public ManoObraNotFoundException(String message) {
        super(message);
    }

    public ManoObraNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
