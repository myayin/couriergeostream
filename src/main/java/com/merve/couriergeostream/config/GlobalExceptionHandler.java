package com.merve.couriergeostream.config;


import com.merve.couriergeostream.dto.BaseResponse;
import com.merve.couriergeostream.dto.Result;
import com.merve.couriergeostream.exception.CourierGeoStreamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CourierGeoStreamException.class)
    public ResponseEntity<BaseResponse> handleException(CourierGeoStreamException ex) {
        BaseResponse errorResponse = new BaseResponse(new Result(ex.getErrorCode(), ex.getMessage()));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BaseResponse> handleException(IllegalArgumentException ex) {
        BaseResponse errorResponse = new BaseResponse(new Result(ex.getMessage(), ex.getMessage()));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleGeneralException(Exception ex) {
        BaseResponse errorResponse = new BaseResponse();
        log.error(ex.getMessage(), ex);
        errorResponse.setResult(Result.error());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
