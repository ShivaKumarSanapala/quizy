package com.quizy.quizservice.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ResponseCode {
  OK("OK"),
  INTERNAL_SERVER_ERROR("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
  INVALID_REQUEST_DATA("Invalid request data"),
  ERROR_FETCHING_QUIZ_DATA("Error fetching quiz data", HttpStatus.NOT_FOUND),
  RESOURCE_NOT_FOUND("The resource you requested was not found", HttpStatus.NOT_FOUND);

  @Getter
  private String message;
  @Getter
  private HttpStatus httpStatus;

  ResponseCode(String message) {
    this.message = message;
    this.httpStatus = HttpStatus.BAD_REQUEST;
  }

  ResponseCode(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }
}
