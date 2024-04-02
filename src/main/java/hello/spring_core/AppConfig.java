package hello.spring_core;

import hello.spring_core.discount.service.DiscountPolicy;
import hello.spring_core.discount.service.impl.RateDiscountPolicy;
import hello.spring_core.member.repository.MemberRepository;
import hello.spring_core.member.repository.impl.MemoryMemberRepository;
import hello.spring_core.member.service.MemberService;
import hello.spring_core.member.service.impl.MemberServiceImpl;
import hello.spring_core.order.service.OrderService;
import hello.spring_core.order.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
