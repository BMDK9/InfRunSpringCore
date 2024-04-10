package hello.spring_core.discount.service.impl;

import static hello.spring_core.discount.service.constant.DiscountAmount.NO_DISCOUNT;
import static hello.spring_core.discount.service.constant.DiscountAmount.VIP_PERCENT_DISCOUNT;

import hello.spring_core.annotation.MainDiscountPolicy;
import hello.spring_core.discount.service.DiscountPolicy;
import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * VIP_PERCENT_DISCOUNT / 100;
        }

        return NO_DISCOUNT;
    }
}
