package si.fri.tpo.pasjehodec.backend.api.exceptions;

import lombok.extern.java.Log;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.DataNotFoundException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Log
/*
lovi exceptione, ki se zgodijo v servisih in na bazi ter kriera primeren API response
 */
public class ExceptionCatcher {

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ExceptionWrapper> handleBadRequestException(BadRequestException exception) {
        log.warning(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionWrapper(exception.getMessage()));
    }

    @ExceptionHandler(value = {ForbiddenOperationException.class})
    public ResponseEntity<ExceptionWrapper> handleForbiddenException(ForbiddenOperationException exception) {
        log.warning(exception.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionWrapper(exception.getMessage()));
    }

    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<ExceptionWrapper> handleDataNotFoundException(DataNotFoundException exception) {
        log.warning(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionWrapper(exception.getMessage()));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionWrapper> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.warning(exception.getMessage());
        var errors = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionWrapper(errors));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionWrapper> handleDefaultException(Exception exception) {
        log.warning(exception.getMessage());
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionWrapper(exception.getMessage()));
    }
}
