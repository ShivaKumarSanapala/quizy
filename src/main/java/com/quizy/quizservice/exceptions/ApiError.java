package com.quizy.quizservice.exceptions;

import com.quizy.quizservice.enums.ResponseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiError extends RuntimeException {

  private final ResponseCode error;
  private final String message;
  private Object data;

  public ApiError(ResponseCode error) {
    super(error.getMessage());
    this.error = error;
    this.message = error.getMessage();
  }

  public ApiError(ResponseCode error, String message) {
    super(message);
    this.error = error;
    this.message = message;
  }

  public ApiError(ResponseCode error, Object data) {
    super(error.getMessage());
    this.error = error;
    this.message = error.getMessage();
    this.data = data;
  }

  public ResponseCode getCode() {
    return error;
  }

  public HttpStatus getHttpStatus() {
    return error.getHttpStatus();
  }
}
