package ItemWeb.ItemWeb.Member;

public class Member {

    private int member_number;
    private String member_id;
    private String member_pw;
    private int member_point;
    private int i;

    public int getMember_number() {
        return member_number;
    }

    public void setMember_number(int member_number) {
        this.member_number = member_number+this.i;
        this.i+=1;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public int getMember_point() {
        return member_point;
    }

    public void setMember_point(int member_point) {
        this.member_point = member_point;
    }




}
