package hello.spring_core.member.repository;

import hello.spring_core.member.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
