package hello.spring_core.member.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import hello.spring_core.AppConfig;
import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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