package com.example.campushub.exam.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExamFindAllResponse {
    private Long id;          // 시험 ID
    private Long userCourseId; // 과목 ID
    private int midScore;     // 중간고사 점수
    private int finalScore;   // 기말고사 점수
    private int totalScore;    // 총점

    @Builder
    @QueryProjection
    public ExamFindAllResponse(Long id, Long userCourseId, int midScore, int finalScore, int totalScore) {
        this.id = id;
        this.userCourseId = userCourseId;
        this.midScore = midScore;
        this.finalScore = finalScore;
        this.totalScore = totalScore;
    }
}
