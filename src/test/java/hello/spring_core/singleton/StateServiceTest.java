package hello.spring_core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StateServiceTest {

    static class TestConfigStateful {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

    static class TestConfigStateless {

        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }
    }

    @Test
    @DisplayName("스테이트풀")
    void statefulServiceSingleton() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfigStateful.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // when
        statefulService1.order("userA", 10000); // ThreadA : A사용자 10000원 주문
        statefulService2.order("userB", 20000); // ThreadB : B사용자 20000원 주문

        // then
        int price = statefulService1.getPrice(); // ThreadA : 사용자 A 주문 금액 조회
        System.out.println("price = " + price);

        // 망한 서비스이다. 샷따 내려.
        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    @Test
    @DisplayName("스테이트리스")
    void statelessServiceSingleton() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfigStateless.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        // when
        int userA = statelessService1.order("userA", 10000);
        int userB = statelessService2.order("userB", 20000);

        // then
        System.out.println("userA = " + userA);
        System.out.println("userB = " + userB);

        assertThat(userA).isNotEqualTo(userB);
    }
}