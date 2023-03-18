package ar.com.besysoft.tallermecanico.controller.handlerException;

import ar.com.besysoft.tallermecanico.exception.alreadyAdded.EntityAlreadyAddedException;
import ar.com.besysoft.tallermecanico.exception.mismatch.EntityMismatchException;
import ar.com.besysoft.tallermecanico.exception.notFound.EntityNotFoundException;
import ar.com.besysoft.tallermecanico.model.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO exceptionHandler(MethodArgumentNotValidException ex) {
        List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
        Map<String, String> detalle = new HashMap<>();
        errorList.forEach(e -> detalle.put(e.getField(), e.getDefaultMessage()));
        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), "Validaciones", detalle);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO notFound(EntityNotFoundException ex) {
        return new ExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDTO mismatch(EntityMismatchException ex) {
        return new ExceptionDTO(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDTO alreadyAdded(EntityAlreadyAddedException ex) {
        return new ExceptionDTO(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                null
        );
    }
}
