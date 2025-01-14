//package com.example.campushub.tuition.controller;
//
//import com.example.campushub.global.security.Login;
//import com.example.campushub.tuition.dto.TuitionFindAllResponse;
//import com.example.campushub.tuition.dto.TuitionSearchCondition;
//import com.example.campushub.tuition.dto.TuitionStudentResponse;
//import com.example.campushub.tuition.service.TuitionService;
//import com.example.campushub.user.dto.LoginUser;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class TuitionController {
//
//    private final TuitionService tuitionService;
//
//
//    @GetMapping("/admin/tuition")
//    public String findTuitions(@Login LoginUser loginUser, TuitionSearchCondition cond, Model model) {
//        List<TuitionFindAllResponse> tuitionList = tuitionService.findTuitions(loginUser, cond);
//        model.addAttribute("tuitionList", tuitionList);
//        model.addAttribute("loginUser", loginUser);
//        return "redirect:/admin/tuitions";
//    }
//
//    @GetMapping("/student/{userNum}/tuition")
//    public String findStudentTuitions(@Login LoginUser loginUser, String userNum, Model model) {
//        TuitionStudentResponse studentTuition = tuitionService.getStudentTuitionDetail(loginUser, userNum);
//        model.addAttribute("studentTuition", studentTuition);
//        model.addAttribute("loginUser", loginUser);
//        return "redirect:/student/{userNum}/tuition";
//    }
//
//    @GetMapping("/student/tuition")
//    public String updatePaymentStatus(@Login LoginUser loginUser, List<String> userNums) {
//        // loginUser가 userNums를 가지고 paymentStatus 업데이터 (대기 -> 납부)
//        tuitionService.updatePaymentStatus(loginUser, userNums);
//        return "redirect:/student/tuitions";
//    }
//
//
//
//}
