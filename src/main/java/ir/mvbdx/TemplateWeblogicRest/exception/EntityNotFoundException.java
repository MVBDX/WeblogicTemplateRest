package ir.mvbdx.TemplateWeblogicRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String id) {
        super("{status.not.found}" + id);
    }
}
