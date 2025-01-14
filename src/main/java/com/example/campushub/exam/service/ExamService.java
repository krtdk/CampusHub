package com.example.campushub.exam.service;

import com.example.campushub.exam.dto.ExamFindAllResponse;
import com.example.campushub.exam.dto.ExamScoreInputRequest;
import com.example.campushub.exam.dto.ExamScoreUpdateResponse;
import com.example.campushub.exam.repository.ExamRepository;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExamService {

    private final UserRepository userRepository;
    private final ExamRepository examRepository;

    public List<ExamFindAllResponse> getExamScores(LoginUser loginUser, Long userCourseId) {
        validateUserRole(loginUser);
        return examRepository.findExamScoresByUserCourseId(userCourseId);
    }

    @Transactional
    public ExamScoreUpdateResponse updateExamScore(LoginUser loginUser, ExamScoreInputRequest request) {
        validateUserRole(loginUser);
        examRepository.updateExamScore(request);

        // 총점 계산 후 응답 DTO 생성
        return ExamScoreUpdateResponse.builder()
                .examId(request.getExamId())
                .midScore(request.getMidScore())
                .finalScore(request.getFinalScore())
                .totalScore(request.getMidScore() + request.getFinalScore()) // 총점 계산
                .build();
    }

    private void validateUserRole(LoginUser loginUser) {
        if (!loginUser.getRole().equals("ADMIN") && !loginUser.getRole().equals("PROFESSOR")) {
            throw new SecurityException("권한이 없습니다.");
        }
    }
}
