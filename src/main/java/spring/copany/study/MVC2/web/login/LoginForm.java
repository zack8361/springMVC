package spring.copany.study.MVC2.web.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import static lombok.AccessLevel.PROTECTED;


@Getter
@NoArgsConstructor(access = PROTECTED)
public class LoginForm {
    private Long id;
    private String password;
}
