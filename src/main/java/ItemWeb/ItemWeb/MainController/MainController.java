package ItemWeb.ItemWeb.MainController;

import ItemWeb.ItemWeb.Member.Member;
import ItemWeb.ItemWeb.RegisterCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "index";
    }

    // login 컨트롤러

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login2(){
        return "login";
    }



    // register 컨트롤러

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register2(HttpServletRequest httpServletRequest){

        String id = httpServletRequest.getParameter("register_id");
        String pw1 = httpServletRequest.getParameter("register_pw1");
        String pw2 = httpServletRequest.getParameter("register_pw2");

        // 회원가입 가능 여부 검사 (RegisterCheck 클래스 이용)
        RegisterCheck registerCheck = new RegisterCheck(id,pw1,pw2);

        if(registerCheck.ID_Check(id)==true && registerCheck.PW_Check(pw1,pw2)==true){
            // 회원가입 성공

            Member member = new Member();

            member.setMember_point(0);
            member.setMember_id(id);
            member.setMember_pw(pw1);
            // 회원 가입 성공 시 기본 포인트 100 지급
            member.setMember_point(100);

            // 회원가입 성공 문구 필요
        }
        else{
            // 회원가입 실패
            // 안내 문구와 함께 회원가입 페이지로 다시 redirect
        }

        return "register";

    }








}
