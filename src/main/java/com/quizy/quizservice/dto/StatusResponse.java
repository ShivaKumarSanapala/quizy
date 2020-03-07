package com.quizy.quizservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.quizy.quizservice.enums.ResponseCode;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusResponse {

  private String message;

  @Enumerated(EnumType.STRING)
  private ResponseCode code;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  private Object data;
}
