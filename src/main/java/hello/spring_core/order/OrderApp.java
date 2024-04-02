package hello.spring_core.order;

import hello.spring_core.AppConfig;
import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import hello.spring_core.member.service.MemberService;
import hello.spring_core.order.entity.Order;
import hello.spring_core.order.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member saveMember = new Member(memberId, "A", Grade.VIP);
        memberService.signIn(saveMember);

        Order saveOrder = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("saveOrder = " + saveOrder);
        System.out.println("saveOrder = " + saveOrder.calculatePrice());
    }
}
