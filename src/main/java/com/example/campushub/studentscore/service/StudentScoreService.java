//package com.example.campushub.studentscore.service;
//
//import com.example.campushub.studentscore.domain.StudentScore;
//import com.example.campushub.studentscore.dto.StudentScoreResponse;
//import com.example.campushub.studentscore.repository.StudentScoreRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class StudentScoreService {
//
//    private final StudentScoreRepository studentScoreRepository;
//
//    public List<StudentScoreResponse> getStudentScores(Long userCourseId) {
//        return studentScoreRepository.findStudentScoresByUserCourseId(userCourseId);
//    }
//
//    @Transactional
//    public void processGraduation(Long userCourseId) {
//        // 수료 처리 로직 구현
//        List<StudentScore> scores = studentScoreRepository.findByUserCourseId(userCourseId);
//        for (StudentScore score : scores) {
//            // 예: score.setGraduated(true); // 수료 상태를 업데이트하는 로직
//            // score.save(); // 필요 시 저장
//        }
//    }
//}
