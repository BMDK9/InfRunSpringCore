package hello.spring_core.discount.service.impl;

import static hello.spring_core.member.constant.DiscountAmount.*;

import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.discount.service.DiscountPolicy;

public class FixDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return VIP_DISCOUNT;
        }
        return NO_DISCOUNT;
    }
}
