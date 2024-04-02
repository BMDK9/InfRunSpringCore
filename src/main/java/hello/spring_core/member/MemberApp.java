package hello.spring_core.member;

import hello.spring_core.AppConfig;
import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.member.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp { // 순수 자바를 이용한 테스트

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member saveMember = new Member(1L, "A", Grade.VIP);
        memberService.signIn(saveMember);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + saveMember.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
