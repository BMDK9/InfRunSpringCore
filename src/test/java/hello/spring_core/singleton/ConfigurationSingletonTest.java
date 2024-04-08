package hello.spring_core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import hello.spring_core.AppConfig;
import hello.spring_core.member.repository.MemberRepository;
import hello.spring_core.member.service.impl.MemberServiceImpl;
import hello.spring_core.order.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("Spring @Bean Singleton test - AppConfig")
    void test() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        // then
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository).isSameAs(memberRepository1);
        assertThat(memberRepository).isSameAs(memberRepository2);
    }
}
