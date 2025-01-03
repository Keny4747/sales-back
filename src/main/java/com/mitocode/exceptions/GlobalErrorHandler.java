package com.mitocode.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// ControlerAdvice es como una especie de disparador, filtro. Cualquier error que suceda lo detecta esta clase
//y lo va a trabajar
@ControllerAdvice
@RestController
public class GlobalErrorHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ModeloNotFoundExcecption.class)
	public ResponseEntity<ErrorDTO> handlerModelNotFound(ModeloNotFoundExcecption ex, WebRequest request){
		ErrorDTO err = new ErrorDTO(LocalDateTime.now(), "ER-N404",request.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.OK);
	}
}
