package hello.spring_core.member.service;

import hello.spring_core.member.entity.Member;

public interface MemberService {

    void signIn(Member member);

    Member findMember(Long memberId);
}
