package com.example.campushub.exam.service;

import com.example.campushub.dept.domain.Dept;
import com.example.campushub.dept.repository.DeptRepository;
import com.example.campushub.exam.domain.Exam;
import com.example.campushub.exam.dto.ExamScoreInputRequest;
import com.example.campushub.exam.dto.ExamScoreUpdateResponse;
import com.example.campushub.exam.repository.ExamRepository;
import com.example.campushub.global.config.QueryDslConfig;
import com.example.campushub.schoolyear.domain.SchoolYear;
import com.example.campushub.schoolyear.domain.Semester;
import com.example.campushub.schoolyear.repository.SchoolYearRepository;
import com.example.campushub.user.domain.*;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import com.example.campushub.usercourse.domain.QUserCourse;
import com.example.campushub.usercourse.domain.UserCourse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

import static com.example.campushub.usercourse.domain.QUserCourse.userCourse;
import static com.mysema.commons.lang.Assert.assertThat;

@DataJpaTest
@Import({ExamService.class, QueryDslConfig.class})
public class ExamServiceTest {

    @Autowired
    ExamService examService;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private SchoolYearRepository schoolYearRepository;

    @AfterEach
    public void tearDown() {
        examRepository.deleteAll();
        userRepository.deleteAll();
        deptRepository.deleteAll();
        schoolYearRepository.deleteAll();
    }
//    @Test
//    @DisplayName("과목별 학생 시험 점수 조회")
//    public void getExamScores(){
//        //given
//        User professor = userRepository.save(createProfessor("0001"));
//        LoginUser loginUser = createLoginUser(professor);
//
//        Dept dept1 = deptRepository.save(createDept("컴소과"));
//        Dept dept2 = deptRepository.save(createDept("실디과"));
//
//        User student1 = userRepository.save(createStudent("김", "10", dept1));
//        User student2 = userRepository.save(createStudent("박", "20", dept2));
//        User student3 = userRepository.save(createStudent("최", "30", dept1));
//
//        examRepository.save(createExam(userCourse, student1, 85, 90));
//
//
//    }
    @Test
    @DisplayName("시험점수 업데이트")
    public void updateExamScore() {
        //given
        User professor = userRepository.save(createProfessor("0001"));
        LoginUser loginUser = createLoginUser(professor);

        Dept dept1 = deptRepository.save(createDept("컴소과"));
        Dept dept2 = deptRepository.save(createDept("실디과"));

        User student1 = userRepository.save(createStudent("김", "10", dept1));
        User student2 = userRepository.save(createStudent("박", "20", dept2));
        User student3 = userRepository.save(createStudent("최", "30", dept1));

        Exam exam = examRepository.save(createExam(0, 0));
        ExamScoreInputRequest request = ExamScoreInputRequest.builder()
                .examId(exam.getId())
                .midScore(85)
                .finalScore(90)
                .build();

        //when
        ExamScoreUpdateResponse response = examService.updateExamScore(loginUser, request);

        //then
        assertThat(response.getExamId()).isEqualTo(exam.getId());
        assertThat(response.getMidScore()).isEqualTo(85);
        assertThat(response.getFinalScore()).isEqualTo(90);
        assertThat(response.getTotalScore()).isEqualTo(175); // 총점 검증
    }

    private Dept createDept(String deptName) {
        return Dept.builder()
                .deptName(deptName)
                .build();
    }

    private User createStudent(String name, String userNum, Dept dept) {
        return User.builder()
                .userName(name)
                .userNum(userNum)
                .password("1234")
                .email("test@gmail.com")
                .dept(dept)
                .phone("1234456567")
                .role(Role.USER)
                .grade(Grade.FIRST_GRADE)
                .type(Type.STUDENT)
                .status(Status.BREAK)
                .build();
    }
    private User createProfessor(String userNum) {
        return User.builder()
                .userName("김교수")
                .userNum(userNum)
                .password("1234")
                .email("test@gmail.com")
                .phone("1234456567")
                .role(Role.USER) // 역할 설정
                .type(Type.PROFESSOR)
                .build();
    }

    private LoginUser createLoginUser(User user) {
        return LoginUser.builder()
                .userNum(user.getUserNum())
                .role(user.getRole())
                .type(user.getType())
                .build();
    }

    private SchoolYear createSchoolYear() {
        return SchoolYear.builder()
                .year(LocalDate.now())
                .semester(Semester.first_semester)
                .is_current(true)
                .build();
    }

    private Exam createExam(int midScore, int finalScore) {
        return Exam.builder()
                .midScore(midScore)
                .finalScore(finalScore)
                .totalScore(midScore+finalScore)
                .build();
    }



}

