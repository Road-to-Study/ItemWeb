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
        member.setMember_point(100); // 회원 가입 성공 시 기본 포인트 100 지급, RegisterController 내에서 해야될지 memberController에서 해야될지 고민
        log.info("회원가입 member={}", member);
        member_map.put(member.getMember_number(), member);
        return member;
    }

    public Member update(int number, int point) {

        Member pointMember = findByNumber(number);
        if (pointMember == null) { // 존재하지 않는 id를 update 하려고 할 때
            return null;
        }
        pointMember.setMember_point(point);
        return pointMember;
    }

    public Member remove(int number) {

        Member removeMember = findByNumber(number);
        if (removeMember == null) { //존재하지 않는 id를 remove 하려고 할 때
            return null;
        }
        member_map.remove(removeMember.getMember_number());
        return removeMember;
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
