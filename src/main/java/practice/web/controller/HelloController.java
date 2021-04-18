package practice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 톰캣이 Controller에게 요청 처리하라 함
// model에 값을 집어넣고
// view 이름을 반환, view에 model도 전달 (resource:template/{viewName}.html)
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello~!");
        return "hello";
    }
}
