//package com.example.campushub.studentscore.repository;
//
//import com.example.campushub.studentscore.dto.QStudentScoreResponse;
//import com.example.campushub.studentscore.dto.StudentScoreResponse;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static com.example.campushub.studentscore.domain.QStudentScore.studentScore;
//import static com.example.campushub.usercourse.domain.QUserCourse.userCourse;
//
//@Repository
//@RequiredArgsConstructor
//public class StudentScoreRepositoryCustomImpl implements StudentScoreRepositoryCustom {
//
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public List<StudentScoreResponse> findStudentScoresByUserCourseId(Long userCourseId) {
//        return queryFactory.select(new QStudentScoreResponse(
//                        userCourse.student.name,
//                        userCourse.student.id,
//                        userCourse.attendanceScore,
//                        userCourse.assignmentScore,
//                        userCourse.examScore,
//                        studentScore.totalScore,
//                        studentScore.grade,
//                        studentScore.credit,
//                        studentScore.percentage
//                ))
//                .from(studentScore)
//                .join(studentScore.userCourse, userCourse)
//                .where(userCourse.id.eq(userCourseId))
//                .fetch();
//    }
//}
