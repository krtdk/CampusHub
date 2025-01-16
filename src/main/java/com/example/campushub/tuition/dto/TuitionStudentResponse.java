package com.example.campushub.tuition.dto;

import com.example.campushub.schoolyear.domain.Semester;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class TuitionStudentResponse {
    private String userNum;      // 학번
    private String userName;    // 이름
    private String deptName;       // 학과명
    private LocalDate year;    // 년도
    private Semester semester;     // 학기
    private int tuitionFee;       // 등록금
    private int scholarshipAmount; // 장학금
    private int totalAmount;       // 총 납부금액
    private String paymentStatus;  // 납부상태

    @Builder
    @QueryProjection
    public TuitionStudentResponse(
            String userNum,
            String userName,
            String deptName,
            LocalDate year,
            Semester semester,
            int tuitionFee,
            int scholarshipAmount,
            String paymentStatus) {
        this.userNum = userNum;
        this.userName = userName;
        this.deptName = deptName;
        this.year = year;
        this.semester = semester;
        this.tuitionFee = tuitionFee;
        this.scholarshipAmount = scholarshipAmount;
        this.totalAmount = tuitionFee - scholarshipAmount;
        this.paymentStatus = paymentStatus;
    }
}