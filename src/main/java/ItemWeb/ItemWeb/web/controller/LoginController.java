package ItemWeb.ItemWeb.web.controller;

import ItemWeb.ItemWeb.member.Member;
import ItemWeb.ItemWeb.repository.MemberRepository;
import ItemWeb.ItemWeb.web.form.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor

public class LoginController {




    @GetMapping("/login")
    public String login(@ModelAttribute("member") LoginForm form) {
        return "login";
    }

    @PostMapping("/login")
    public String login2(@Validated @ModelAttribute("member") LoginForm form, BindingResult bindingResult,
                         @RequestParam(defaultValue = "/") String redirectURL,
                         HttpServletRequest request) {

        // 관리자 계정으로 로그인 한 경우 관리자 페이지로 이동 ( id=admin pw=1234 )

        if(form.getMember_id().equals("admin") && form.getMember_pw().equals("1234")){
            log.warn("관리자 계정이 로그인 하였습니다.");
            return "admin";
        }


        if (bindingResult.hasErrors()) {
            return "/login";
        }

//        Optional<Member> member = memberRepository.findById(form.getMember_id());
//
//        log.warn(member.toString());
//
//        if (member == null) {
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀립니다.");
//            return "/login";
//        }




//
//         로그인 성공 처리 - 세션 쿠키
//
//        세션 반환(없으면 생성)
//        HttpSession session = request.getSession();
//
//        세션에 로그인 정보 저장
//        session.setAttribute("member", member);
//
//       로그인 시 10 포인트 지급
//        member.setMember_point(member.getMember_point()+10);

        return "redirect:" + redirectURL;
    }
//
//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//
//        if (session != null) {
//            session.invalidate();
//        }
//        return "redirect:/";
//    }
}
