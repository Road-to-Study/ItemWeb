package ItemWeb.ItemWeb.web.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterForm {

    @NotEmpty
    private String member_id;

    @NotEmpty
    private String member_pw;

    @NotEmpty
    private String member_pw2;
}
