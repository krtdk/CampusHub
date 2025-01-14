//package com.example.campushub.usertuition.repository;
//
//import com.example.campushub.usertuition.dto.UserTuitionDto;
//import com.querydsl.core.types.Projections;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
//import com.example.campushub.usertuition.domain.QUserTuition;
//
//@RequiredArgsConstructor
//public class UserTuitionRepositoryCustomImpl implements UserTuitionRepositoryCustom {
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public List<UserTuitionDto> searchUserTuitions(
//            Boolean paymentStatus,
//            Long deptId,
//            String searchKeyword) {
//
//        return queryFactory
//                .select(Projections.constructor(UserTuitionDto.class,
//                        userTuition.id,
//                        userTuition.user.name,
//                        userTuition.user.studentId,
//                        userTuition.user.dept.name,
//                        userTuition.paymentStatus,
//                        userTuition.paymentDate
//                ))
//                .from(userTuition)
//                .join(userTuition.user)
//                .join(userTuition.user.dept)
//                .where(
//                        paymentStatusEq(paymentStatus),
//                        deptIdEq(deptId),
//                        searchKeywordContains(searchKeyword)
//                )
//                .fetch();
//    }
//    public void updatePaymentStatus(List<Long> userTuitionIds, boolean paymentStatus) {
//        queryFactory
//                .update(userTuition)
//                .set(userTuition.paymentStatus, paymentStatus)
//                .where(userTuition.id.in(userTuitionIds))
//                .execute();
//    }
//    private BooleanExpression paymentStatusEq(Boolean status) {
//        return status != null ? userTuition.paymentStatus.eq(status) : null;
//    }
//
//    private BooleanExpression deptIdEq(Long deptId) {
//        return deptId != null ? userTuition.user.dept.id.eq(deptId) : null;
//    }
//
//    private BooleanExpression searchKeywordContains(String keyword) {
//        if (StringUtils.isEmpty(keyword)) return null;
//        return userTuition.user.userName.contains(keyword)
//                .or(userTuition.user.userNum.contains(keyword));
//    }
//}