package hello.spring_core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.spring_core",  // 지정하지 않으면 ComponentScan 이 붙은
//        basePackageClasses = AutoAppConfig.class, // 정보 클래스의 패키지가 시작위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 예제 코드 AppConfig 를 살리기 위해서 필터 적용
public class AutoAppConfig {

}
