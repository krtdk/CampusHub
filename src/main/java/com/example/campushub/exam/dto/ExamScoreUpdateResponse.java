package com.example.campushub.exam.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExamScoreUpdateResponse {
    private Long examId;      // 시험 ID
    private int midScore;     // 중간고사 점수
    private int finalScore;   // 기말고사 점수
    private int totalScore;    // 총점

    @Builder
    @QueryProjection
    public ExamScoreUpdateResponse(Long examId, int midScore, int finalScore, int totalScore) {
        this.examId = examId;
        this.midScore = midScore;
        this.finalScore = finalScore;
        this.totalScore = totalScore; // 총점 계산
    }
}
