package practice.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.web.domain.Member;
import practice.web.repository.MemberRepository;
import practice.web.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service // 애노테이션이 붙어있으면 스프링 컨테이너가 관리한다
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired //구현체 중에서도 스프링 빈으로 등록되어 있는 MemoryMemberRepository를 주입해준다
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //같은 이름이 있는 중복 회원x
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
