package az.matrix.springmatrix161.controller;

import az.matrix.springmatrix161.dto.ExceptionDTO;
import az.matrix.springmatrix161.exception.AlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class GEHandler {


//    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDTO handle(AlreadyExistsException ex) {
        log.error("Action.log ALREADY_EXISTS_EXCEPTION -> {}", ex.getMessage());
        return ExceptionDTO.builder()
                .code(HttpStatus.CONFLICT.value())
                .status(HttpStatus.CONFLICT)
                .message(ex.getMessage()).build();
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionDTO> userException(AlreadyExistsException ex, WebRequest webRequest) {
        log.error("Exception -> EXCEPTION {}", ex.getMessage());
        ExceptionDTO exceptionDTO = ExceptionDTO.builder()
                .message(webRequest.getDescription(false))
                .build();
        System.out.println(webRequest.getContextPath());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }


}
