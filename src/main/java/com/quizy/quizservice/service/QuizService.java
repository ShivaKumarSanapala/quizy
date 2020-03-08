package com.quizy.quizservice.service;

import com.quizy.quizservice.dto.request.CreateQuizRequest;
import com.quizy.quizservice.dto.response.QuizResponse;
import com.quizy.quizservice.enums.ResponseCode;
import com.quizy.quizservice.exceptions.ApiError;
import com.quizy.quizservice.model.Quiz;
import com.quizy.quizservice.repository.QuizRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizService {

  private final QuizRepository quizRepository;

  @Transactional
  public QuizResponse createQuiz(CreateQuizRequest createQuizRequest) {
    Quiz quiz = Quiz.builder()
        .quizName(createQuizRequest.getQuizName())
        .className(createQuizRequest.getClassName())
        .quizDate(createQuizRequest.getQuizDate())
        .startTime(createQuizRequest.getStartTime())
        .subject(createQuizRequest.getSubject())
        .build();
    quizRepository.save(quiz);
    return buildQuizResponse(quiz, createQuizRequest);
  }

  private QuizResponse buildQuizResponse(Quiz quiz, CreateQuizRequest createQuizRequest) {
    return QuizResponse.builder()
        .quizName(quiz.getQuizName())
        .userId(createQuizRequest.getUserId())
        .className(quiz.getClassName())
        .quizDate(quiz.getQuizDate())
        .startTime(quiz.getStartTime())
        .updatedAt(quiz.getUpdatedAt())
        .createdAt(quiz.getCreatedAt())
        .build();
  }

  public QuizResponse getQuizById(Long id, Long userId) {
    Optional<Quiz> quizOptional = quizRepository.findById(id);
    if (!quizOptional.isPresent())
      throw new ApiError(ResponseCode.ERROR_FETCHING_QUIZ_DATA, ResponseCode.ERROR_FETCHING_QUIZ_DATA.getMessage());
    Quiz quiz = quizOptional.get();
    return buildQuizResponse(quiz, userId);
  }

  private QuizResponse buildQuizResponse(Quiz quiz, Long userId) {
    return QuizResponse.builder()
        .quizName(quiz.getQuizName())
        .userId(userId)
        .className(quiz.getClassName())
        .quizDate(quiz.getQuizDate())
        .startTime(quiz.getStartTime())
        .updatedAt(quiz.getUpdatedAt())
        .createdAt(quiz.getCreatedAt())
        .build();
  }
}
