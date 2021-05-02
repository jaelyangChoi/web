package practice.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.web.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //MemberRepository에는 이미 똑같은 시그니처의 메서드가 선언되어 있으므로 생략 가능
//    @Override
//    Optional<Member> findByName(String name);
}
