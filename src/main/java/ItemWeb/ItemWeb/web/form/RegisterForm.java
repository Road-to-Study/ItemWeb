package ItemWeb.ItemWeb.web.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterForm {

    @NotEmpty
    private String member_id;

    @Min(value = 1000,message = "1000-9999 까지의 숫자를 입력하세요.")
    @Max(value=9999,message = "1000-9999 까지의 숫자를 입력하세요.")
    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String member_pw;


    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String member_pw2;
}
