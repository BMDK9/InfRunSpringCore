package hello.spring_core.order;

import hello.spring_core.AppConfig;
import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.member.service.MemberService;
import hello.spring_core.order.entity.Order;
import hello.spring_core.order.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member saveMember = new Member(memberId, "A", Grade.VIP);
        memberService.signIn(saveMember);

        Order saveOrder = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("saveOrder = " + saveOrder);
        System.out.println("saveOrder = " + saveOrder.calculatePrice());
    }
}
