package hello.spring_core.member.service.crud;

import hello.spring_core.member.entity.Member;

public interface MemberCrudService {

    void signIn(Member member);

    Member findMember(Long memberId);
}
