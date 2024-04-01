package hello.spring_core.discount.service;

import hello.spring_core.member.entity.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
