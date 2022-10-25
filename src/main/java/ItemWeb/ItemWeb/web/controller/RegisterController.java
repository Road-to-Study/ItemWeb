package ItemWeb.ItemWeb.web.controller;

import ItemWeb.ItemWeb.member.Grade;
import ItemWeb.ItemWeb.member.Member;
import ItemWeb.ItemWeb.member.MemberRepository;
import ItemWeb.ItemWeb.web.form.RegisterForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final MemberRepository memberRepository;

    @GetMapping("/register")
    public String register(@ModelAttribute("member") RegisterForm form) {
        return "register";
    }

    @PostMapping("/register")
    public String register2(@Validated @ModelAttribute("member") RegisterForm form, BindingResult bindingResult) {
        log.info("MemberRegisterForm = {}", form);
        //회원가입 가능 여부 검사 (RegisterCheck 클래스 이용 -> valid 이용)

        //아이디 중복 검사, 오류검사 중에서 가장 먼저 실행
        Optional<Member> hasSameIdMember = memberRepository.findById(form.getMember_id());
        if (hasSameIdMember.isPresent()) {
            bindingResult.rejectValue("member_id", "idDication", "중복된 아이디가 존재합니다.");
            return "/register";
        }

        //검증 실패 시 다시 회원가입 페이지으로
        if (bindingResult.hasErrors()) {
            log.info("error : {}", bindingResult);
            return "/register";
        }

        //입력한 두 패스워드가 서로 다를 때 (복합 필드 검증)
        if (!form.getMember_pw().equals(form.getMember_pw2())) {
            bindingResult.reject("differentPassword", "두 비밀번호가 다릅니다."); // errors.properties 추가는 안함
            return "/register";
        }

        //회원가입 성공
        Member member = new Member();
        member.setMember_id(form.getMember_id());
        member.setMember_pw(form.getMember_pw());
        member.setGrade(Grade.NORMAL);
        log.info("member = {}", member);

        // 회원 레포지토리에 저장
        memberRepository.register(member);

        // 회원가입 성공 문구 필요


        // 회원가입 성공 후 홈으로 리다이렉트
        return "redirect:/";
    }

}
