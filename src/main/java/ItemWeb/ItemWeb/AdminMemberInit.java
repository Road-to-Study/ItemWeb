package ItemWeb.ItemWeb;

import ItemWeb.ItemWeb.member.Grade;
import ItemWeb.ItemWeb.member.Member;
import ItemWeb.ItemWeb.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class AdminMemberInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setMember_id("admin");
        member.setMember_pw("1234");
        member.setGrade(Grade.ADMIN);

        memberRepository.register(member);
    }
}
