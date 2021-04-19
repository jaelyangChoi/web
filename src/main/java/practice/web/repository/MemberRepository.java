package practice.web.repository;

import practice.web.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id); //Null을 처리하는 방법. Optional로 감싸서 반환.

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
