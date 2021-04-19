package practice.web.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.web.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 다른 곳에서 가져다 쓸게 아니라 public 안 해도 됨
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /**
     * 테스트는 순서와 상관없이 서로에게 영향을 미치지 않도록 설계해야 한다.
     * 테스트 순서 보장 안되므로.
     * 따라서 테스트 후에 공용 데이터, db 초기화 해줘야 한다.
     **/
    //test 메소드 각각이 실행 끝나고 호출되는 콜백 메소드
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);//id setting 됨
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result); junit
        assertThat(member).isEqualTo(result);//assertj
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("name1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("name2");
        repository.save(member2);

        Member result = repository.findByName("name1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("name1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("name2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
