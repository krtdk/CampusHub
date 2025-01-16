package com.example.campushub.tuition.service;

import com.example.campushub.dept.domain.Dept;
import com.example.campushub.dept.repository.DeptRepository;
import com.example.campushub.global.config.QueryDslConfig;
import com.example.campushub.scholarship.domain.PaymentType;
import com.example.campushub.scholarship.domain.Scholarship;
import com.example.campushub.scholarship.repository.ScholarshipRepository;
import com.example.campushub.schoolyear.domain.SchoolYear;
import com.example.campushub.schoolyear.domain.Semester;
import com.example.campushub.schoolyear.repository.SchoolYearRepository;
import com.example.campushub.tuition.domain.Tuition;
import com.example.campushub.tuition.dto.TuitionFindAllResponse;
import com.example.campushub.tuition.dto.TuitionSearchCondition;
import com.example.campushub.tuition.dto.TuitionStudentResponse;
import com.example.campushub.tuition.repository.TuitionRepository;
import com.example.campushub.tuition.service.TuitionService;
import com.example.campushub.user.domain.*;
import com.example.campushub.user.dto.LoginUser;
import com.example.campushub.user.repository.UserRepository;
import com.example.campushub.userscholarship.domain.UserScholarship;
import com.example.campushub.userscholarship.repository.UserScholarshipRepository;
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
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
    @Autowired
    private ScholarshipRepository scholarshipRepository;
    @Autowired
    private UserScholarshipRepository userScholarshipRepository;

    @AfterEach
    public void tearDown() {
        userTuitionRepository.deleteAll();
        tuitionRepository.deleteAll();
        userRepository.deleteAll();
        deptRepository.deleteAll();
        schoolYearRepository.deleteAll();
    }

    @Test
    @DisplayName("등록금 전체 + 컨디션 조회")
    public void findTuitions() {
        //given
        User admin = userRepository.save(createAdmin("0001"));
        LoginUser loginUser = createLoginUser(admin);

        Dept dept1 = deptRepository.save(createDept("컴소과"));
        Dept dept2 = deptRepository.save(createDept("실디과"));

        User student1 = userRepository.save(createStudent("김", "10", dept1));
        User student2 = userRepository.save(createStudent("박", "20", dept2));
        User student3 = userRepository.save(createStudent("최", "30", dept1));

        Tuition tuition = tuitionRepository.save(createTuition(10000, dept1));
        Tuition tuition2 = tuitionRepository.save(createTuition(20000, dept2));

        SchoolYear year = schoolYearRepository.save(createSchoolYear());

        userTuitionRepository.save(createUserTuition(student1, tuition, year,PaymentStatus.NONE));
        userTuitionRepository.save(createUserTuition(student2, tuition2, year, PaymentStatus.NONE));
        userTuitionRepository.save(createUserTuition(student3, tuition, year, PaymentStatus.NONE));

        TuitionSearchCondition cond = createCondition("컴소과",null, null);
        TuitionSearchCondition cond2 = createCondition("실디과", null, null);
        TuitionSearchCondition cond3 = createCondition(null, "10", null);
        TuitionSearchCondition cond4 = createCondition(null, null, PaymentStatus.NONE);
        TuitionSearchCondition cond5 = createCondition(null, null, null);

        //when
        List<TuitionFindAllResponse> result1 = tuitionService.findTuitions(loginUser, cond);
        List<TuitionFindAllResponse> result2 = tuitionService.findTuitions(loginUser, cond2);
        List<TuitionFindAllResponse> result3 = tuitionService.findTuitions(loginUser, cond3);
        List<TuitionFindAllResponse> result4 = tuitionService.findTuitions(loginUser, cond4);
        List<TuitionFindAllResponse> result5 = tuitionService.findTuitions(loginUser, cond5);

        //then
        assertThat(result1.size()).isEqualTo(2);
        assertThat(result1.get(0).getUserNum()).isEqualTo(student1.getUserNum());
        assertThat(result1.get(1).getUserNum()).isEqualTo(student3.getUserNum());
        assertThat(result2.size()).isEqualTo(1);
        assertThat(result2.get(0).getUserNum()).isEqualTo(student2.getUserNum());
        assertThat(result3.size()).isEqualTo(1);
        assertThat(result3.get(0).getUserNum()).isEqualTo(student1.getUserNum());
        assertThat(result4.size()).isEqualTo(3);
        assertThat(result4.get(0).getUserNum()).isEqualTo(student1.getUserNum());
        assertThat(result5.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("등록 여부 변경")
    public void updatePaymentStatus() {
        //given
        User admin = userRepository.save(createAdmin("0001"));
        LoginUser loginUser = createLoginUser(admin);

        Dept dept1 = deptRepository.save(createDept("컴소과"));
        User student1 = userRepository.save(createStudent("김", "10", dept1));
        User student2 = userRepository.save(createStudent("이", "20", dept1));
        User student3 = userRepository.save(createStudent("박", "30", dept1));


        Tuition tuition = tuitionRepository.save(createTuition(10000, dept1));
        SchoolYear year = schoolYearRepository.save(createSchoolYear());

        // 초기 상태를 WAITING으로 설정
        UserTuition userTuition1 = userTuitionRepository.save(createUserTuition(student1, tuition, year,PaymentStatus.WAITING));
        UserTuition userTuition2 = userTuitionRepository.save(createUserTuition(student2, tuition, year,PaymentStatus.WAITING));
        UserTuition userTuition3 = userTuitionRepository.save(createUserTuition(student3, tuition, year,PaymentStatus.WAITING));


        // 사용자 번호 리스트를 준비합니다.
        List<String> userNums = List.of(student1.getUserNum(),student2.getUserNum(),student3.getUserNum());

        //when
        tuitionService.updatePaymentStatus(loginUser, userNums);
        List<UserTuition> result = List.of(userTuition1, userTuition2, userTuition3);

        //then
        assertThat(userTuition1.getPaymentStatus()).isEqualTo(PaymentStatus.SUCCESS);
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getPaymentStatus()).isEqualTo(PaymentStatus.SUCCESS);
        assertThat(result.get(1).getPaymentStatus()).isEqualTo(PaymentStatus.SUCCESS);
        assertThat(result.get(2).getPaymentStatus()).isEqualTo(PaymentStatus.SUCCESS);


    }


    @Test
    @DisplayName("학생(본인) 등록금 조회")
    public void getStudentTuitionDetail() {
        //given(테스트 데이터를 줄 때)
        Dept dept = deptRepository.save(createDept("컴퓨터 소프트웨어학과"));
        User user = userRepository.save(createStudent("박", "10", dept));
        LoginUser loginUser = createLoginUser(user);

        Scholarship ship = scholarshipRepository.save(createScholarship("성적장학금"));
        Tuition tuition = tuitionRepository.save(createTuition(100000, user.getDept()));
        SchoolYear schoolYear = schoolYearRepository.save(createSchoolYear());

        userScholarshipRepository.save(createUserScholarship(user, ship, schoolYear));
        userTuitionRepository.save(createUserTuition(user, tuition, schoolYear,PaymentStatus.NONE));

        //when
        TuitionStudentResponse result = tuitionService.getStudentTuitionDetail(loginUser);

        //then
        assertThat(result.getTuitionFee()).isEqualTo(100000);
        assertThat(result.getTotalAmount()).isEqualTo(90000);
        assertThat(result.getScholarshipAmount()).isEqualTo(10000);
    }

    @Test
    @DisplayName("등록금 납부 신청")
    public void applyTuitionPayment() {
        //given(테스트 데이터를 줄 때)
        Dept dept = deptRepository.save(createDept("컴퓨터 소프트웨어학과"));
        User user = userRepository.save(createStudent("박", "10", dept));
        LoginUser loginUser = createLoginUser(user);

        Scholarship ship = scholarshipRepository.save(createScholarship("성적장학금"));
        Tuition tuition = tuitionRepository.save(createTuition(100000, user.getDept()));
        SchoolYear schoolYear = schoolYearRepository.save(createSchoolYear());

        userScholarshipRepository.save(createUserScholarship(user, ship, schoolYear));
        UserTuition ut = userTuitionRepository.save(createUserTuition(user, tuition, schoolYear, PaymentStatus.NONE));

        // when
        tuitionService.applyTuitionPayment(loginUser, tuition.getId()); // 납부 신청 메서드 호출

        // then
//        assertThat(result.isWaitPaymentStatus()).isFalse(); // 상태는 이제 WAITING이 아니어야 함
//        assertThat(updatedUserTuition.isSuccessPaymentStatus()).isTrue(); // 성공적으로 납부 상태로 변경되었어야 함
        assertThat(ut.getPaymentStatus()).isEqualTo(PaymentStatus.WAITING);


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
    private User createAdmin(String userNum) {
        return User.builder()
                .userName("김관리")
                .userNum(userNum)
                .password("1234")
                .email("test@gmail.com")
                .phone("1234456567")
                .role(Role.ADMIN)
                .type(Type.ADMIN)
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

    private UserTuition createUserTuition(User user, Tuition tuition, SchoolYear schoolYear, PaymentStatus status) {
        return UserTuition.builder()
                .user(user)
                .schoolYear(schoolYear)
                .tuition(tuition)  // 이미 저장된 Tuition 객체를 사용합니다.
                .paymentStatus(status)
                .paymentDate(LocalDate.now())
                .build();
    }
    private Scholarship createScholarship(String name) {
        return Scholarship.builder()
                .scholarshipName(name)
                .type(PaymentType.POST_PAYMENT)
                .amount(10000)
                .build();
    }
    private UserScholarship createUserScholarship(User user, Scholarship scholarship, SchoolYear schoolYear) {
        return UserScholarship.builder()
                .user(user)
                .scholarship(scholarship)
                .schoolYear(schoolYear)
                .confDate(LocalDate.now())
                .build();
    }
    private TuitionSearchCondition createCondition (String deptame, String userNum, PaymentStatus status) {
        return TuitionSearchCondition.builder()
                .deptName(deptame)
                .userNum(userNum)
                .paymentStatus(status)
                .build();
    }
}
