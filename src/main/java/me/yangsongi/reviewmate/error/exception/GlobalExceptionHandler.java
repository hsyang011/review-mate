package me.yangsongi.reviewmate.error.exception;

import lombok.extern.slf4j.Slf4j;
import me.yangsongi.reviewmate.error.ErrorCode;
import me.yangsongi.reviewmate.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice // 모든 컨트롤러에서 발생하는 예외를 잡아서 처리
public class GlobalExceptionHandler {

    // 지원하지 않은 HTTP method 호출 할 경우 발생
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class) // HttpRequestMethodNotSupportedException 예외를 잡아서 처리
    protected ResponseEntity<ErrorResponse> handle(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException", e);
        return createErrorResponseEntity(ErrorCode.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        return createErrorResponseEntity(ErrorCode.INVALID_INPUT_VALUE);
    }

    @ExceptionHandler(BusinessBaseException.class)
    protected ResponseEntity<ErrorResponse> handle(BusinessBaseException e) {
        log.error("BusinessException", e);
        return createErrorResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handle(Exception e) {
        e.printStackTrace();
        log.error("Exception", e);
        return createErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> createErrorResponseEntity(ErrorCode errorCode) {
        return new ResponseEntity<>(
                ErrorResponse.of(errorCode),
                errorCode.getStatus());
    }

}