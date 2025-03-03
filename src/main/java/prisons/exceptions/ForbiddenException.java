package prisons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Prisoner Can't Scape")
public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;
}
