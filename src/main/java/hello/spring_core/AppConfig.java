package hello.spring_core;

import hello.spring_core.discount.service.impl.FixDiscountPolicy;
import hello.spring_core.member.repository.impl.MemoryMemberRepository;
import hello.spring_core.member.service.MemberService;
import hello.spring_core.member.service.impl.MemberServiceImpl;
import hello.spring_core.order.service.OrderService;
import hello.spring_core.order.service.impl.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
