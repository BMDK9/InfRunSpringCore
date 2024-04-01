package hello.spring_core.member.service.impl;

import static org.assertj.core.api.Assertions.*;

import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl();

    @DisplayName("가입")
    @Test
    void signIn() {
        // given
        Member testSaveMember = new Member(1L, "A", Grade.VIP);

        // when
        memberService.signIn(testSaveMember);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(testSaveMember).isEqualTo(findMember);
    }
}