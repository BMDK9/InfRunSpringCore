package hello.spring_core.order.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.member.service.MemberService;
import hello.spring_core.member.service.impl.MemberServiceImpl;
import hello.spring_core.order.entity.Order;
import hello.spring_core.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @DisplayName("주문 생성")
    @Test
    void creatOrder() {
        // given
        Long memberId = 1L;
        Member testSaveMember = new Member(memberId, "A", Grade.VIP);
        memberService.signIn(testSaveMember);

        Order testOrder = orderService.createOrder(memberId, "itemA", 10000);

        // when then
        assertThat(testOrder.getDiscountPrice()).isEqualTo(1000);

    }
}