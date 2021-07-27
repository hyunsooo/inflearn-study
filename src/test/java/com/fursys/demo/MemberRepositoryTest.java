package com.fursys.demo;

import com.fursys.demo.domain.Member;
import com.fursys.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)  // 테스트 코드는 기본적으로 실행 이후, 롤백 처리한다. 이를 막으려면 옆 어노테이션을 사용한다.
    public void testMember() throws Exception {
        // given
        Member member = new Member();
        member.setName("memberA");

        // when
        memberRepository.save(member);
        Member findMember = memberRepository.findOne(member.getId());

        // then
        assertEquals(findMember.getId(), member.getId());
        assertEquals(findMember.getName(), member.getName());

        // true이다.
        // 같은 영속성 컨텍스트 안에서 같은 아이디를 가진 엔티티는 똑같다.
        assertEquals(findMember, member);

    }
}