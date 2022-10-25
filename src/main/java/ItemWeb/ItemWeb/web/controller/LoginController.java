package ItemWeb.ItemWeb.web.controller;

import ItemWeb.ItemWeb.login.LoginService;
import ItemWeb.ItemWeb.member.Member;
import ItemWeb.ItemWeb.web.form.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login(@ModelAttribute("member") LoginForm form) {
        return "login";
    }

    @PostMapping("/login")
    public String login2(@Validated @ModelAttribute("member") LoginForm form, BindingResult bindingResult,
                         @RequestParam(defaultValue = "/") String redirectURL,
                         HttpServletRequest request) {

//        // 관리자 계정으로 로그인 한 경우 관리자 페이지로 이동 ( id=admin pw=1234 )
//
//        if(form.getMember_id().equals("admin") && form.getMember_pw().equals("1234")){
//            log.warn(form.getMember_id());
//            return "admin";
//        }

        if (bindingResult.hasErrors()) {
            return "/login";
        }

        Member member = loginService.login(form.getMember_id(), form.getMember_pw());

        if (member == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀립니다.");
            return "/login";
        }

        log.warn(member.getMember_id());
        log.warn(member.getMember_pw());

        // 로그인 성공 처리 - 세션 쿠키

        //세션 반환(없으면 생성)
        HttpSession session = request.getSession();
        //세션에 로그인 정보 저장
        session.setAttribute("member", member);

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
