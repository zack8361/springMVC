package spring.copany.study.MVC.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void save() throws Exception {
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll() throws Exception {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        Member member3 = new Member("member3", 40);

        Member save = memberRepository.save(member1);
        Member save1 = memberRepository.save(member2);
        Member save2 = memberRepository.save(member3);
        //when

        List<Member> memberList = memberRepository.findAll();
        for (Member member : memberList) {
            System.out.println(member);
        }
        //then
        assertThat(memberList.size()).isEqualTo(3);
        assertThat(memberList).contains(member1, member2, member3);
    }



}