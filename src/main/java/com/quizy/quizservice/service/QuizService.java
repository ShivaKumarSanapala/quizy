package com.quizy.quizservice.service;

import com.quizy.quizservice.dto.request.CreateQuizRequest;
import com.quizy.quizservice.dto.response.CreateQuizResponse;
import com.quizy.quizservice.model.Quiz;
import com.quizy.quizservice.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizService {

  private final QuizRepository quizRepository;

  public CreateQuizResponse createQuiz(CreateQuizRequest createQuizRequest){
    Quiz quiz = Quiz.builder()
        .quizName(createQuizRequest.getQuizName())
        .build();
    quizRepository.save(quiz);
    return CreateQuizResponse.builder()
        .quizName(quiz.getQuizName())
        .userId(createQuizRequest.getUserId())
        .build();
  }
}
