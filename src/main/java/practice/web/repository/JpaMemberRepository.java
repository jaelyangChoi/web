package practice.web.repository;

import practice.web.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
    //jpa는 entity manager를 통해 동작. 라이브러리 받으면 부트가 생성해줌. dataSource 설정 등 포함
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //persist:영구 저장하다. member에 setId까지 해준다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); //조회할 타입, 식별자 pk
        return Optional.ofNullable(member);
    }

    //pk 기반이 아니면 jpql 작성해야 함.
    //jpql: 테이블이 아닌 엔티티 대상 쿼리. 객체 자체를 select. (->sql로 번역됨)
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member as m", Member.class).getResultList();
    }
}
