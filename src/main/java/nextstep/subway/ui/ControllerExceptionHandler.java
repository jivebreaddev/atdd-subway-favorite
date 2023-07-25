package nextstep.subway.ui;

import nextstep.member.exception.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgsException(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body(ExceptionResponse.from(e));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgsException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(ExceptionResponse.from(e));
    }


}
