package si.fri.tpo.pasjehodec.backend.api.exceptions;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.DataNotFoundException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;

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

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionWrapper> handleDefaultException(Exception exception) {
        log.warning(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionWrapper(exception.getMessage()));
    }
}
