package com.quizy.quizservice.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ResponseCode {
  OK("OK"),
  INTERNAL_SERVER_ERROR("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
  INVALID_REQUEST_DATA("Invalid request data"),
  ERROR_FETCHING_PATIENT_DATA("Error fetching patient data"),
  ERROR_FETCHING_DOCTOR_DATA("Error fetching doctor data"),
  RESOURCE_NOT_FOUND("The resource you requested was not found", HttpStatus.NOT_FOUND),
  ROOM_NOT_FOUND("The room you requested was not found", HttpStatus.OK),
  EARLY_LINK_ACCESS("Link has been accessed too early", HttpStatus.OK),
  LINK_ACTIVE("Link is active", HttpStatus.OK),
  LINK_EXPIRED("Link has expired", HttpStatus.OK),
  INVALID_LINK_TOKEN("Invalid link token"),
  CALL_ENDED("Call has ended", HttpStatus.OK);

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
