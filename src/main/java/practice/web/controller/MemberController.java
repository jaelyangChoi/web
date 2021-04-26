package practice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import practice.web.service.MemberService;


@Controller
public class MemberController {
    //매번 컨트롤러에서 service 객체를 new해서 객체를 생성하면 불필요하게 여러개 인스턴스를 생성하게 된다.
    private final MemberService memberService;

    //DI: 의존관계 주입
    @Autowired //@Autowired이 붙어있으면 컨테이너에 있는 의존성을 가져다 연결해준다.
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }
}
