package practice.web.repository;

import org.springframework.stereotype.Repository;
import practice.web.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    //일단 동시성 문제 배제
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Null일 가능성이 있으므로 Optional로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();//없으면 optional 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // test 끝나고 store 지울 수 있도록
    public void clearStore(){
        store.clear();
    }
}
