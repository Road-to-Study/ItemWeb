package ItemWeb.ItemWeb;

import ItemWeb.ItemWeb.web.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //로그인 인증 인터셉터 추가 - 홈화면, 로그인, 로그아웃, 회원가입 제외
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1) // 인터셉터 순서
                .addPathPatterns("/**") // 모든 url 검증
                .excludePathPatterns("/", "/login", "/logout", "/register", "/css/**", "/*.ico", "/error"); // 예외
    }
}
