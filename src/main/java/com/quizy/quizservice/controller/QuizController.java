package com.quizy.quizservice.controller;

import com.quizy.quizservice.dto.SuccessResponseWrapper;
import com.quizy.quizservice.dto.request.CreateQuizRequest;
import com.quizy.quizservice.dto.response.QuizResponse;
import com.quizy.quizservice.service.QuizService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QuizController {

  private final QuizService quizService;

  @PostMapping("/quiz}")
  public ResponseEntity<SuccessResponseWrapper<QuizResponse>> createQuiz(
      @Valid @RequestBody CreateQuizRequest createQuizRequest
  ) {
    QuizResponse response = quizService.createQuiz(createQuizRequest);
    return ResponseEntity.ok(SuccessResponseWrapper.<QuizResponse>builder().result(
        response
    ).build());
  }

  @GetMapping("/quiz/{quizId}")
  public ResponseEntity<SuccessResponseWrapper<QuizResponse>> test(
      @PathVariable(value = "quizId") Long quizId
  ){
    Long userId = null;
    QuizResponse quizResponse = quizService.getQuizById(quizId, userId);
    return ResponseEntity.ok(SuccessResponseWrapper.<QuizResponse>builder().result(
        quizResponse
    ).build());
  }
}
