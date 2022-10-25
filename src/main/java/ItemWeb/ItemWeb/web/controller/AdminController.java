package ItemWeb.ItemWeb.web.controller;

import ItemWeb.ItemWeb.member.Grade;
import ItemWeb.ItemWeb.member.Member;
import ItemWeb.ItemWeb.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MemberRepository memberRepository;

    @GetMapping
    public String admin(@SessionAttribute(name = "member", required = false) Member loginMember, Model model) {

        if (loginMember == null || !loginMember.getGrade().equals(Grade.ADMIN)) {
            log.info("로그인하지 않았거나 관리자 권한이 없는 사용자가 접근");
            return "redirect:/";
        }

        model.addAttribute("member", loginMember);
        model.addAttribute("members", memberRepository.findEveryMember());
        return "admin/admin";
    }

    @GetMapping("point")
    public String admin_point(@SessionAttribute(name = "member", required = false) Member loginMember, Model model) {
        if (loginMember == null || !loginMember.getGrade().equals(Grade.ADMIN)) {
            log.info("로그인하지 않았거나 관리자 권한이 없는 사용자가 접근");
            return "redirect:/";
        }

        model.addAttribute("member", loginMember);
        return "admin/point";
    }

    @PostMapping("point/{member_number}")
    public String adminControlPoint(@PathVariable(value = "member_number") int number,
                                    @PathVariable(value = "point") int point) {

        //point 변경
        Member pointMember = memberRepository.update(number, point);

        //받은 member_id 를 가진 사용자가 없을 때
        if (pointMember == null) {
            log.error("잘못된 멤버 번호");
            return "redirect:/admin/point";
        }

        //다시 admin으로
        return "admin";
    }

    @GetMapping("remove")
    public String admin_remove(@SessionAttribute(name = "member", required = false) Member loginMember, Model model) {

        if (loginMember == null || !loginMember.getGrade().equals(Grade.ADMIN)) {
            log.info("로그인하지 않았거나 관리자 권한이 없는 사용자가 접근");
            return "redirect:/";
        }

        model.addAttribute("member", loginMember);
        return "admin/remove";
    }


    @PostMapping("remove/{member_number}")
    public String adminRemoveMember(@PathVariable(value = "member_number") int number) {

        //point 변경
        Member removeMember = memberRepository.remove(number);

        //받은 member_number 를 가진 사용자가 없을 때
        if (removeMember == null) {
            log.error("잘못된 멤버 번호");
            return "redirect:/admin/remove";
        }

        //다시 admin으로
        return "admin";
    }
}
