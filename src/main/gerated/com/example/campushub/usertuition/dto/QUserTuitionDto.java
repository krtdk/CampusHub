package com.example.campushub.usertuition.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.campushub.usertuition.dto.QUserTuitionDto is a Querydsl Projection type for UserTuitionDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserTuitionDto extends ConstructorExpression<UserTuitionDto> {

    private static final long serialVersionUID = 810413443L;

    public QUserTuitionDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> studentId, com.querydsl.core.types.Expression<String> deptName, com.querydsl.core.types.Expression<Boolean> paymentStatus, com.querydsl.core.types.Expression<? extends java.util.Date> paymentDate) {
        super(UserTuitionDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, boolean.class, java.util.Date.class}, id, userName, studentId, deptName, paymentStatus, paymentDate);
    }

}

