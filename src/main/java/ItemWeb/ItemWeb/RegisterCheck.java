package ItemWeb.ItemWeb;

public class RegisterCheck {

    private String id;
    private String pw1;
    private String pw2;


    public RegisterCheck(String id, String pw1, String pw2) {
        this.id = id;
        this.pw1 = pw1;
        this.pw2 = pw2;
    }



    public boolean ID_Check(String id) {

        // ID 중복 검사 필요

        return false;
    }



    public boolean PW_Check(String pw1, String pw2) {

        // 두 비밀번호 일치 확인 후 일치 시 true return

        if (pw1.equals(pw2)) {
            return true;
        }

        return false;
    }




}






