package hello.spring_core.discount.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    @Test
    void VIP_Discount_O() {
        // given
        Member testVIPMember = new Member(1L, "VIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(testVIPMember, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @DisplayName("VIP가 아니면 할인이 적용되지 않는다")
    @Test
    void BASIC_Discount_X() {
        // given
        Member testBASICMember = new Member(1L, "BASIC", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(testBASICMember, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}