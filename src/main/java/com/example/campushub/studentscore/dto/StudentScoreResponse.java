package com.example.campushub.studentscore.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentScoreResponse {
    private String studentName;   // 학생 이름
    private String studentId;     // 학번
    private int attendanceScore;   // 출석 점수
    private int assignmentScore;   // 과제 점수
    private int examScore;         // 시험 점수
    private int totalScore;        // 총 점수
    private String grade;          // 등급
    private int credit;            // 학점
    private int percentage;        // 백분율

@Builder
@QueryProjection
    public StudentScoreResponse (String studentName, String studentId, int attendanceScore, int assignmentScore, int examScore, int totalScore, String grade, int credit, int percentage) {
    this.studentName = studentName;
    this.studentId = studentId;
    this.attendanceScore = attendanceScore;
    this.assignmentScore = assignmentScore;
    this.examScore = examScore;
    this.totalScore = totalScore;
    this.grade = grade;
    this.credit = credit;
    this.percentage = percentage;
}

}
