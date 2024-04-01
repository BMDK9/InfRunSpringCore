package hello.spring_core.member.service.crud.impl;

import static org.assertj.core.api.Assertions.*;

import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.member.service.crud.MemberCrudService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberCrudServiceImplTest {

    MemberCrudService memberCrudService = new hello.spring_core.member.service.crud.impl.MemberCrudServiceImpl();

    @DisplayName("가입")
    @Test
    void signIn() {
        // given
        Member testSaveMember = new Member(1L, "A", Grade.VIP);

        // when
        memberCrudService.signIn(testSaveMember);
        Member findMember = memberCrudService.findMember(1L);

        // then
        assertThat(testSaveMember).isEqualTo(findMember);
    }
}