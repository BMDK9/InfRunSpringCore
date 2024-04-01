package hello.spring_core.order.service.impl;

import hello.spring_core.member.entity.Member;
import hello.spring_core.order.entity.Order;
import hello.spring_core.order.service.OrderService;
import hello.spring_core.member.repository.MemberRepository;
import hello.spring_core.member.repository.impl.MemoryMemberRepository;
import hello.spring_core.discount.service.DiscountPolicy;
import hello.spring_core.discount.service.impl.FixDiscountPolicy;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
