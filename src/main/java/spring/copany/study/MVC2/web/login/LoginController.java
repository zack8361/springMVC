package spring.copany.study.MVC2.web.login;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public String login(LoginForm loginForm, HttpServletResponse response) {

        Member loginMember
                = loginService.login(loginForm.getId(), loginForm.getPassword());

        // 쿠키에 시간 정보를 주지 않으면 세션 쿠키(브라우저 종료시 모두 종료)
        response.addCookie(new Cookie("memberId", String.valueOf(loginMember.getId())));

        return "login";
    }

    // 로그인 성공 후 화면
    @GetMapping("/home")
    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        if (memberId == null) {
            return "redirect:/login";
        }

        return "home";
    }
}
