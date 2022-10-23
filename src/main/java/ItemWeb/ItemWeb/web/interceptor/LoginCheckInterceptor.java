package ItemWeb.ItemWeb.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("로그인 체크 인터셉터 실행 {}", requestURI);

        HttpSession session = request.getSession();
        //현재 세션의 로그인 인증 확인
        if (session == null || session.getAttribute("member") == null) {
            log.info("로그인 인증 실패");

            //로그인 화면으로 리다이렉스
            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;
        }

        log.info("로그인 인증 성공");
        return true;
    }
}
