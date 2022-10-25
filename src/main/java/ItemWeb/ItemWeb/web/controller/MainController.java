package ItemWeb.ItemWeb.web.controller;

import ItemWeb.ItemWeb.member.Member;
import ItemWeb.ItemWeb.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String home(@SessionAttribute(name = "member", required = false) Member loginMember, Model model){

        List<Member> members = memberRepository.findEveryMember();
        model.addAttribute("members", members);

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
