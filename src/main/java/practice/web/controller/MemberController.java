package practice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice.web.controller.dto.MemberForm;
import practice.web.domain.Member;
import practice.web.service.MemberService;

import java.util.List;

//controller는 어차피 spring이 관리한다
@Controller
public class MemberController {
    //매번 컨트롤러에서 service 객체를 new해서 객체를 생성하면 불필요하게 여러개 인스턴스를 생성하게 된다.
    private final MemberService memberService;

    //DI: 의존관계 주입
    @Autowired //@Autowired이 붙어있으면 컨테이너에 있는 의존성을 가져다 연결해준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "/members/memberList";
    }
}
