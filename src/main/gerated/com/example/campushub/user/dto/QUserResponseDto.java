package com.example.campushub.user.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.campushub.user.dto.QUserResponseDto is a Querydsl Projection type for UserResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserResponseDto extends ConstructorExpression<UserResponseDto> {

    private static final long serialVersionUID = -951230198L;

    public QUserResponseDto(com.querydsl.core.types.Expression<String> userNum, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<java.time.LocalDateTime> birthday, com.querydsl.core.types.Expression<String> deptName, com.querydsl.core.types.Expression<com.example.campushub.user.domain.Grade> grade, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> phone, com.querydsl.core.types.Expression<String> address) {
        super(UserResponseDto.class, new Class<?>[]{String.class, String.class, java.time.LocalDateTime.class, String.class, com.example.campushub.user.domain.Grade.class, String.class, String.class, String.class}, userNum, userName, birthday, deptName, grade, email, phone, address);
    }

}

