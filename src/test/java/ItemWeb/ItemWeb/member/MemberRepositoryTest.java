package ItemWeb.ItemWeb.member;

import ItemWeb.ItemWeb.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class MemberRepositoryTest {

    MemberRepository memberRepository = new MemberRepository();

    @Test
    void register() {
        Member member = new Member();
        member.setMember_id("qwer");
        member.setMember_pw("qwer");
        memberRepository.register(member);

    }

    @Test
    void update() {
        Optional<Member> testMember = memberRepository.findById("qwer");
        if (testMember.isEmpty()) {
            return;
        }
        memberRepository.update(testMember.get().getMember_number(), 50);

    }

    @Test
    void mapTest() {
        Map<Integer, Member> testMap = new HashMap<>();

        Member member1 = new Member();
        member1.setMember_id("id1");
        member1.setMember_pw("pw1");
        testMap.put(1, member1);
        Member member2 = new Member();
        member2.setMember_id("id2");
        member2.setMember_pw("pw2");
        testMap.put(2, member2);
        Member member3 = new Member();
        member3.setMember_id("id3");
        member3.setMember_pw("pw3");
        testMap.put(3, member3);

        Member testMember2 = testMap.get(2);
        testMember2.setMember_point(40);

        System.out.println("testMap = " + testMap);
    }
}
