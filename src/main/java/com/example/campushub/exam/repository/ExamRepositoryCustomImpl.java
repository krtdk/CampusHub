package com.example.campushub.exam.repository;

import com.example.campushub.exam.dto.ExamFindAllResponse;
import com.example.campushub.exam.dto.ExamScoreInputRequest;
import com.example.campushub.exam.dto.QExamFindAllResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.campushub.exam.domain.QExam.exam;

@RequiredArgsConstructor
public class ExamRepositoryCustomImpl implements ExamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    // 과목별 학생 시험 점수 조회
    @Override
    public List<ExamFindAllResponse> findExamScoresByUserCourseId(Long userCourseId) {
        return queryFactory.select(new QExamFindAllResponse(
                        exam.id,
                        exam.userCourse.id,
                        exam.midScore,
                        exam.finalScore,
                        exam.totalScore
                ))
                .from(exam)
                .where(eqUserCourseId(userCourseId))
                .fetch();
    }

    // 시험 점수 업데이트
    @Override
    @Transactional
    public void updateExamScore(ExamScoreInputRequest request) {
        queryFactory
                .update(exam)
                .set(exam.midScore, request.getMidScore())
                .set(exam.finalScore, request.getFinalScore())
                .set(exam.totalScore, request.getMidScore() + request.getFinalScore()) // 총점 계산
                .where(exam.id.eq(request.getExamId()))
                .execute();
    }

    private BooleanExpression eqUserCourseId(Long userCourseId) {
        return userCourseId == null ? null : exam.userCourse.id.eq(userCourseId);
    }
}
