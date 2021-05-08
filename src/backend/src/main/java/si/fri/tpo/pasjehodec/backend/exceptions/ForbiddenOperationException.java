package si.fri.tpo.pasjehodec.backend.exceptions;

public class ForbiddenOperationException extends Exception{
    public ForbiddenOperationException() {
    }

    public ForbiddenOperationException(String message) {
        super(message);
    }
}
