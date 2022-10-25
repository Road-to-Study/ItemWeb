package ItemWeb.ItemWeb.member;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_number;

    @NotEmpty
    private String member_id;

    @NotEmpty
    private String member_pw;

    private int member_point;
}
