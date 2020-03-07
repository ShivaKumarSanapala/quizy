package com.quizy.quizservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.quizy.quizservice.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SuccessResponseWrapper<T> {

  @Default
  private StatusResponse status = StatusResponse.builder().code(ResponseCode.OK).message(ResponseCode.OK.getMessage())
      .build();
  private T result;
}
