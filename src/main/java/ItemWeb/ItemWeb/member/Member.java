package ItemWeb.ItemWeb.member;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private int member_number;

    @NotEmpty
    private String member_id;

    @NotEmpty
    private String member_pw;

    private int member_point;

    private Grade grade;
}
