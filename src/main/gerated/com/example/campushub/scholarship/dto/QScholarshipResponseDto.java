package com.example.campushub.scholarship.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.campushub.scholarship.dto.QScholarshipResponseDto is a Querydsl Projection type for ScholarshipResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QScholarshipResponseDto extends ConstructorExpression<ScholarshipResponseDto> {

    private static final long serialVersionUID = -462465088L;

    public QScholarshipResponseDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> scholarshipName, com.querydsl.core.types.Expression<com.example.campushub.scholarship.domain.PaymentType> type, com.querydsl.core.types.Expression<Integer> amount, com.querydsl.core.types.Expression<Long> departmentId) {
        super(ScholarshipResponseDto.class, new Class<?>[]{long.class, String.class, com.example.campushub.scholarship.domain.PaymentType.class, int.class, long.class}, id, scholarshipName, type, amount, departmentId);
    }

}

