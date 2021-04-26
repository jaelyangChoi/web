package practice.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.web.repository.MemberRepository;
import practice.web.repository.MemoryMemberRepository;
import practice.web.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());//container에 등록되어 있는 빈을 주입

    }

    @Bean //singleton으로 동작
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
