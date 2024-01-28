package hello.Member;

import hello.member.Member;
import hello.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest() {
        Member member = new Member("memberId001", "memberA");
        memberRepository.initTable();
        memberRepository.save(member);
        Member member1 = memberRepository.find(member.getMemberId());
        assertThat(member1.getName()).isEqualTo(member.getName());
        assertThat(member1.getMemberId()).isEqualTo(member.getMemberId());
    }

}