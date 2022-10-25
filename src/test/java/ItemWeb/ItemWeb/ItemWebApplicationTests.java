package ItemWeb.ItemWeb;


import ItemWeb.ItemWeb.member.Member;

import ItemWeb.ItemWeb.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.not;

@SpringBootTest
@WebAppConfiguration
class ItemWebApplicationTests {
	@Autowired
	MemberRepository memberRepository;

	@Test
	void 회원가입_포인트_조회() {



		Member member = new Member();
		member.setMember_id("test");
		member.setMember_pw("1234");
		member.setMember_point(90);


		Assertions.assertEquals(90,member.getMember_point());

	}


//	@Test
//	void 회원가입_기능_확인(){
//
//		// 미구현
//
//
//
//		Member member = new Member();
//		member.setMember_id("test");
//		member.setMember_pw("1234");
//		member.setMember_point(90);
//
//		memberRepository.register(member);
//
//
//
//
//	}


}
