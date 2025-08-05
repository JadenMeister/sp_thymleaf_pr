package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import com.example.demo.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> userList = new ArrayList<>();

    // 사용자 등록 폼을 보여주는 메소드
    // @GetMapping: HTTP GET 요청을 처리하는 메소드
    // "/user" 경로로 요청이 들어오면 이 메소드가 호출됨
    // Model: 뷰에 데이터를 전달하기 위한 객체
    @GetMapping("/")
    public String indexPage() {
        // User 객체를 생성하여 모델에 추가
        // 반환 뷰
        return "index";
    }

    @GetMapping("/user")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/user/data")
    public String signupData(@ModelAttribute User user, Model model) {
        // user 객체는 @ModelAttribute에 의해 자동으로 생성됨
        // user 객체의 필드에 폼 데이터가 바인딩됨


        // 모델에 사용자 정보를 추가
        model.addAttribute("user", user);

        return "result";
    }
}
