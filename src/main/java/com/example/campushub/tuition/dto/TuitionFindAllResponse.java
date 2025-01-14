package com.example.campushub.tuition.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class TuitionFindAllResponse {

    private String username;
    private String userNum;
    private String deptName;
    private String userType;
    private String paymentStatus;
    private Date paymentDate;

    @Builder
    @QueryProjection
    public TuitionFindAllResponse(String username, String userNum, String deptName,
                                  String userType, String paymentStatus, Date paymentDate) {
        this.username = username;
        this.userNum = userNum;
        this.deptName = deptName;
        this.userType = userType;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }
}
