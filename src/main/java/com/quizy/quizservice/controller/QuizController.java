package com.quizy.quizservice.controller;

import com.quizy.quizservice.dto.SuccessResponseWrapper;
import com.quizy.quizservice.dto.request.CreateQuizRequest;
import com.quizy.quizservice.dto.response.CreateQuizResponse;
import com.quizy.quizservice.service.QuizService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QuizController {

  private final QuizService quizService;

  @PostMapping("/create/quiz}")
  public ResponseEntity<SuccessResponseWrapper<CreateQuizResponse>> createQuiz(
      @Valid @RequestBody CreateQuizRequest createQuizRequest
  ) {
    CreateQuizResponse response = quizService.createQuiz(createQuizRequest);
    return ResponseEntity.ok(SuccessResponseWrapper.<CreateQuizResponse>builder().result(
        response
    ).build());
  }
}
