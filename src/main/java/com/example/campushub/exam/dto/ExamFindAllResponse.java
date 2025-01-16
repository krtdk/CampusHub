package com.example.campushub.exam.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExamFindAllResponse {
    private String username;
    private String userNum;
    private String deptName;
    private Long userCourseId; // 과목 ID
    private int midScore;     // 중간고사 점수
    private int finalScore;   // 기말고사 점수
    private int totalScore;    // 총점

    @Builder
    @QueryProjection
    public ExamFindAllResponse(String username, String userNum, String deptName,
                                Long userCourseId, int midScore, int finalScore, int totalScore) {
        this.username = username;
        this.userNum = userNum;
        this.deptName = deptName;
        this.userCourseId = userCourseId;
        this.midScore = midScore;
        this.finalScore = finalScore;
        this.totalScore = totalScore;
    }
}
