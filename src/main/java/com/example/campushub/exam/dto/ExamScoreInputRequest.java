package com.example.campushub.exam.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExamScoreInputRequest {
    private Long examId;      // 시험 ID
    private int midScore;     // 중간고사 점수
    private int finalScore;   // 기말고사 점수

    @Builder
    @QueryProjection
    public ExamScoreInputRequest(Long examId, int midScore, int finalScore) {
        this.examId = examId;
        this.midScore = midScore;
        this.finalScore = finalScore;
    }
}
