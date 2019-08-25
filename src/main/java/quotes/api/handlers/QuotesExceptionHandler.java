package quotes.api.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import quotes.api.model.QuoteError;
import quotes.api.model.enums.StatusCode;

@RestControllerAdvice
public class QuotesExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>(new QuoteError(StatusCode.ERROR.name(),
				ex.getBindingResult().getFieldError().getDefaultMessage(), StatusCode.ERROR.ordinal()), status);
	}

}
