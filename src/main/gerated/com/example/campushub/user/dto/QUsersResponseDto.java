package com.example.campushub.user.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.campushub.user.dto.QUsersResponseDto is a Querydsl Projection type for UsersResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUsersResponseDto extends ConstructorExpression<UsersResponseDto> {

    private static final long serialVersionUID = 153595295L;

    public QUsersResponseDto(com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userNum, com.querydsl.core.types.Expression<String> username, com.querydsl.core.types.Expression<String> deptName, com.querydsl.core.types.Expression<com.example.campushub.user.domain.Type> type, com.querydsl.core.types.Expression<com.example.campushub.user.domain.Status> status) {
        super(UsersResponseDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, com.example.campushub.user.domain.Type.class, com.example.campushub.user.domain.Status.class}, userId, userNum, username, deptName, type, status);
    }

}

