package hello.spring_core.autowired;

import hello.spring_core.member.entity.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    static class TestBean{

        @Autowired(required = false) // 스프링이 관리하는 빈이 아닌 것을 넣었을 떄
        public void setNoBean1(Member noBean1) { // 자동 주입할 대상이 없으면 메서드 자체가 호출 안됨
            System.out.println("noBean1 = " + noBean1);
        }
        
        @Autowired // 자동 주입할 대상이 없으면 스프링 컨테이너에 없으면 null이 된다.
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired // 자동 주입할 대상이 없으면 Optional.empty 가 입력된다.
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }

    @Test
    @DisplayName("옵션 처리")
    void AutoWiredOption() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

        // when


        // then

    }
}
