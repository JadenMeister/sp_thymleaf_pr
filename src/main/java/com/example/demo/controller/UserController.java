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

    private List<User> userDataList = new ArrayList<>();

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

       for(User duplicateUser : userDataList) {
           if(duplicateUser.getUsername().equals(user.getUsername())) {
               // 중복이 되는 경우
                model.addAttribute("error", "이미 사용중인 아이디 입니다. ");
                user.setUsername("");// 중복된 아이디를 빈 문자열로 초기화
                model.addAttribute("user", user);
                return "signup"; // 다시 회원가입 폼으로 돌아감
           }
       }
        // 검증이 끝나면
        // 모델에 사용자 정보를 추가
        userDataList.add(user);

        model.addAttribute("user", user);
        model.addAttribute("userDataList", userDataList);
        model.addAttribute("success", "회원가입이 완료되었습니다!");
        // 결과페이지를 반환함
        return "result";
    }
}
