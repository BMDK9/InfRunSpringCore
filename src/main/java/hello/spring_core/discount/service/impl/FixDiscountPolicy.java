package hello.spring_core.discount.service.impl;

import static hello.spring_core.discount.service.constant.DiscountAmount.NO_DISCOUNT;
import static hello.spring_core.discount.service.constant.DiscountAmount.VIP_FIX_DISCOUNT;

import hello.spring_core.discount.service.DiscountPolicy;
import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return VIP_FIX_DISCOUNT;
        }

        return NO_DISCOUNT;
    }
}
