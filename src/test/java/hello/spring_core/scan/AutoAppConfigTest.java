package hello.spring_core.scan;

import hello.spring_core.AutoAppConfig;
import hello.spring_core.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    @DisplayName("컴포넌트 스캔")
    void basicScan() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
                AutoAppConfig.class);

        // when
        MemberService memberService = ac.getBean(MemberService.class);

        // then
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
