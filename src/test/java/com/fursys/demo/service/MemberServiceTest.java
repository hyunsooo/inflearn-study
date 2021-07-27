package com.fursys.demo.service;

import com.fursys.demo.domain.Member;
import com.fursys.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
//    @Autowired EntityManager em;

    @Test
    public void join() throws Exception {
        // given
        Member member = new Member();
        member.setName("han");

        // when
        Long savedId = memberService.join(member);

        // then
//        em.flush();
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void duplicate_member_error() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim1");
        Member member2 = new Member();
        member2.setName("kim1");

        // when
        memberService.join(member1);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        // then
        assertEquals("이미 존재하는 회원입니다.", exception.getMessage());
    }

}