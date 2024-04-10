package hello.spring_core.autowired;


import static org.assertj.core.api.Assertions.assertThat;

import hello.spring_core.AutoAppConfig;
import hello.spring_core.discount.service.DiscountPolicy;
import hello.spring_core.member.constant.Grade;
import hello.spring_core.member.entity.Member;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AllBeanTest {

    static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap,
                List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }

    @Test
    @DisplayName("모든 빈을 호출")
    void findAllBean() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,
                DiscountService.class);

        // when
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);

        // then
        int fixDiscountPrice = discountService.discount(member, 20000, "fixDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(fixDiscountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(rateDiscountPrice).isEqualTo(2000);
    }
}
