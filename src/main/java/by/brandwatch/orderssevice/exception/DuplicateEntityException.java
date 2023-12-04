package by.brandwatch.orderssevice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(String entityName) {
        super("Duplicate entity: " + entityName);
    }
}
