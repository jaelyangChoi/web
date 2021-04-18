package practice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 톰캣이 Controller에게 요청 처리하라 함
// model에 값을 집어넣고
// view 이름을 반환, view에 model도 전달 (resource:template/{viewName}.html)
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) { //Model: DTO. View에 전달
        model.addAttribute("data", "hello~!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { // RequestParam - required: default True
        model.addAttribute("name", name);
        return "mvc-template";
    }

    //VIEW(HTML)이 아닌 Data 전달
    @GetMapping("hello-string")
    @ResponseBody //HTML의 <body>가 아닌 HTTP Response의 Body부에 이 data를 직접 넣겠다.
    public String helloString(@RequestParam("name") String name) { //Model 필요 없다!
        return "hello" + name;
    }

    //객체 데이터를 전달
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json으로 변환되서 Response body에 담긴다.
    }

    //static: 숨기지 않아도 되는 클래스
    static class Hello {
        private String name;

        //getter&setter를 이용한 프로퍼티 접근 방식이 java bean 규약.
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
