package hello.spring_core.member.service.impl;

import hello.spring_core.member.entity.Member;
import hello.spring_core.member.repository.MemberRepository;
import hello.spring_core.member.repository.impl.MemoryMemberRepository;
import hello.spring_core.member.service.MemberService;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void signIn(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}