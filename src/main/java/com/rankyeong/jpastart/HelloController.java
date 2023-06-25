package com.rankyeong.jpastart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")    // 'hello' url로 GET 요청이 올 때
    public String hello(Model model) {
        // Model에 데이터를 실어서 Controller를 통해 View로 넘길 수 있음
        model.addAttribute("data", "hello!!!");  // 'data' 키에 'hello!!!' 값 지정
        return "hello";    // return 값: 화면 이름
    }
}
