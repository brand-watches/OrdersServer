package by.brandwatch.orderssevice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntitiesNotFoundByIdsException extends RuntimeException {
    public EntitiesNotFoundByIdsException(List<Long> invalidIds, String name) {
        super("Invalid Ids " + name + ": " + invalidIds.toString());
    }
}
