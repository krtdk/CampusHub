package com.example.campushub.tuition.service;

import com.example.campushub.dept.domain.Dept;
import com.example.campushub.dept.repository.DeptRepository;
import com.example.campushub.global.config.QueryDslConfig;
import com.example.campushub.schoolyear.domain.SchoolYear;
import com.example.campushub.schoolyear.domain.Semester;
import com.example.campushub.schoolyear.repository.SchoolYearRepository;
import com.example.campushub.tuition.domain.Tuition;
import com.example.campushub.tuition.dto.TuitionStudentResponse;
import com.example.campushub.tuition.repository.TuitionRepository;
import com.example.campushub.tuition.service.TuitionService;
import com.example.campushub.user.domain.*;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import com.example.campushub.usertuition.domain.PaymentStatus;
import com.example.campushub.usertuition.domain.UserTuition;
import com.example.campushub.usertuition.repository.UserTuitionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

@DataJpaTest
@Import({TuitionService.class, QueryDslConfig.class})
public class TuitionServiceTest {

    @Autowired
    TuitionService tuitionService;
    @Autowired
    TuitionRepository tuitionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserTuitionRepository userTuitionRepository;
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private SchoolYearRepository schoolYearRepository;

    @AfterEach
    public void tearDown() {
        userTuitionRepository.deleteAll();
        tuitionRepository.deleteAll();
        userRepository.deleteAll();
        deptRepository.deleteAll();
        schoolYearRepository.deleteAll();
    }

    @Test
    @DisplayName("학생 등록금 조회")
    public void getStudentTuitionDetail() {
        //given(테스트 데이터를 줄 때)
        Dept dept = deptRepository.save(createDept("컴퓨터 소프트웨어학과"));
        User user = userRepository.save(createUser("240012", dept));
        LoginUser loginUser = createLoginUser(user);

        // Tuition 객체를 먼저 저장합니다.
        Tuition tuition = tuitionRepository.save(createTuition(1000, user.getDept()));
        SchoolYear schoolYear = schoolYearRepository.save(createSchoolYear());

        // UserTuition 객체를 생성할 때 저장된 Tuition 객체를 사용합니다.
        UserTuition ut = userTuitionRepository.save(createUserTuition(user, tuition, schoolYear));

        //when
        TuitionStudentResponse result = tuitionService.getStudentTuitionDetail(loginUser);

        //then
        Assertions.assertThat(result.getTuitionFee()).isEqualTo(1000);
    }

    private Dept createDept(String deptName) {
        return Dept.builder()
                .deptName(deptName)
                .build();
    }

    private User createUser(String userNum, Dept dept) {
        return User.builder()
                .userName("박정우")
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

    private Tuition createTuition(int fee, Dept dept) {
        return Tuition.builder()
                .dept(dept)
                .tuitionFee(fee)
                .build();
    }

    private UserTuition createUserTuition(User user, Tuition tuition, SchoolYear schoolYear) {
        return UserTuition.builder()
                .user(user)
                .schoolYear(schoolYear)
                .tuition(tuition)  // 이미 저장된 Tuition 객체를 사용합니다.
                .paymentStatus(PaymentStatus.NONE)
                .paymentDate(LocalDate.now())
                .build();
    }
}
