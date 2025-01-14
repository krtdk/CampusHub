//package com.example.campushub.studentscore.controller;
//
//import com.example.campushub.studentscore.domain.StudentScore;
//import com.example.campushub.studentscore.service.StudentScoreService;
//import com.example.campushub.usercourse.domain.UserCourse;
//import com.example.campushub.usercourse.service.UserCourseService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class StudentScoreController {
//
//    private final StudentScoreService studentScoreService;
//    private final UserCourseService userCourseService;
//
//    // 강의별 학생 점수 입력 폼
//    @GetMapping("/scores")
//    public String showScoreInputForm(@RequestParam Long courseId, Model model) {
//        UserCourse userCourse = userCourseService.findById(courseId);
//        List<StudentScore> scores = studentScoreService.findScoresByCourse(userCourse);
//        model.addAttribute("userCourse", userCourse);
//        model.addAttribute("scores", scores);
//        return "scoreInput"; // scoreInput.html로 이동
//    }
//
//    // 점수 저장
//    @PostMapping("/scores/save")
//    public String saveScore(@RequestParam Long courseId, StudentScore studentScore) {
//        studentScoreService.saveScore(studentScore);
//        return "redirect:/scores?courseId=" + courseId; // 점수 입력 후 해당 강의의 점수 목록으로 리다이렉트
//    }
//
//    // 점수 수정 폼
//    @GetMapping("/scores/edit")
//    public String editScore(@RequestParam Long scoreId, Model model) {
//        StudentScore score = studentScoreService.findById(scoreId);
//        model.addAttribute("score", score);
//        return "scoreEdit"; // scoreEdit.html로 이동
//    }
//
//    // 점수 수정
//    @PostMapping("/scores/update")
//    public String updateScore(StudentScore studentScore) {
//        studentScoreService.updateScore(studentScore);
//        return "redirect:/scores?courseId=" + studentScore.getUserCourse().getId(); // 점수 수정 후 해당 강의의 점수 목록으로 리다이렉트
//    }
//}
