package spring.copany.study.MVC2.web.login;


import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Override
    public Member login(Long id, String password) {
        return new Member(1L, "이찬호");
    }

}
