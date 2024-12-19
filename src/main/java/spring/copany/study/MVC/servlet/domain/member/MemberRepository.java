package spring.copany.study.MVC.servlet.domain.member;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Getter
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {

    }

    /**
     * 회원 저장
     * @param member
     * @return
     */
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    /**
     * 회원 조회
     * @param id
     * @return
     */
    public Member findById(Long id) {
        return store.get(id);
    }

    /**
     * 회원 전체 조회
     * @return
     */
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * 회원 초기화
     */
    public void clearStore() {
        store.clear();
    }
}
