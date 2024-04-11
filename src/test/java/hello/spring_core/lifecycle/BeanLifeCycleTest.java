package hello.spring_core.lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring-core.dev");
            return networkClient;
        }
    }
    @Test
    @DisplayName("빈 생명주기 테스트1")
    void lifeCycleTest1() {
        // 스프링 빈은 "객체 생성 -> 의존관계 주입" 의 라이프 사이클을 가진다. 예외는 있다(생성자 주입).
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class); // 그래서 여기서는 Url은 null이 들어온다.
        ac.close();
    }

}
