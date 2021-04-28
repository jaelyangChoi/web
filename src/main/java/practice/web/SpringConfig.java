package practice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.web.repository.JdbcMemberRepository;
import practice.web.repository.JdbcTemplateMemberRepository;
import practice.web.repository.MemberRepository;
import practice.web.repository.MemoryMemberRepository;
import practice.web.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    /*DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체.
    스프링 부트는 application.properties의 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둔다.
    그래서 DI를 받을 수 있다.*/

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());//container에 등록되어 있는 빈을 주입
    }

    @Bean //singleton으로 동작
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);//개발자가 직접 생성할 경우 autowired 안 먹힌다.
    }
}
