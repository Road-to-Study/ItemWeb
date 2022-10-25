package ItemWeb.ItemWeb.web.controller;

import ItemWeb.ItemWeb.member.Member;
//import ItemWeb.ItemWeb.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home(@SessionAttribute(name = "member", required = false) Member loginMember, Model model){

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

}
