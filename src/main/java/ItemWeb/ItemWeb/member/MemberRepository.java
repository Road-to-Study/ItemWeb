package ItemWeb.ItemWeb.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Integer, Member> member_map = new HashMap<Integer, Member>();
    private static int sequence = 0;

    public Member register(Member member) {
        member.setMember_number(++sequence);
        log.info("회원가입 member={}", member);
        member_map.put(member.getMember_number(), member);
        return member;
    }

    public Member findByNumber(int number) {
        return member_map.get(number);
    }

    public Optional<Member> findById(String id) {
        return findEveryMember().stream()
                .filter(m -> m.getMember_id().equals(id))
                .findFirst();
    }

    public List<Member> findEveryMember() {
        return new ArrayList<>(member_map.values());
    }

    public void clearMap() {
        member_map.clear();
    }

}
