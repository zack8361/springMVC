package spring.copany.study.MVC2.web.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 세션 관리
 */
@Component
public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    /**
     * 세션 생성
     * SessionId 생성 (임의의 추정 불가능한 문자열)
     * 세션 저장소에 sessionId와 보관할 값 저장
     * SessionId로 응답 쿠키를 생성
     */
    public void createSession(Object value, HttpServletResponse response) {

        // 세션 ID 후 저장
        String randomSessionId = UUID.randomUUID().toString();
        sessionStore.put(randomSessionId, value);

        // 쿠키 생성
        response.addCookie(new Cookie(SESSION_COOKIE_NAME, randomSessionId));
    }

    /**
     * 세션 조회
     */
    public Object getSession(HttpServletRequest request) {
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
}
