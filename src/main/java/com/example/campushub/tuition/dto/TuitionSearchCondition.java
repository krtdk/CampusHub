package com.example.campushub.tuition.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TuitionSearchCondition {

    private String deptName;
    private String userNum;
    private String paymentStatus;

    @Builder
    private TuitionSearchCondition(String deptName, String userNum, String paymentStatus) {
        this.deptName = deptName;
        this.userNum = userNum;
        this.paymentStatus = paymentStatus;
    }

    public static TuitionSearchCondition of(String deptName, String userNum, String paymentStatus) {
        return TuitionSearchCondition.builder()
                .deptName(deptName)
                .userNum(userNum)
                .paymentStatus(paymentStatus)
                .build();
    }
}
