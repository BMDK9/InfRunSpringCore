package hello.spring_core.discount.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixDiscountPolicyTest {

    FixDiscountPolicy discountPolicy = new FixDiscountPolicy();


    @DisplayName("VIP는 1000원 할인된다.")
    @Test
    void VIP_FixDiscount_O() {
        // given
        Member testVIPMember = new Member(1L, "A", Grade.VIP);

        // when
        int discount = discountPolicy.discount(testVIPMember, 5000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @DisplayName("VIP가 아니면 할인 안된다.")
    @Test
    void BASIC_FixDiscount_X() {
        // given
        Member testBASICMember = new Member(1L, "A", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(testBASICMember, 5000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}
