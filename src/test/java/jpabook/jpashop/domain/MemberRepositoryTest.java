package jpabook.jpashop.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class) //스프링부트와 테스트할거라는 뜻
@SpringBootTest
class MemberRepositoryTest {
//    @Autowired MemberRepository memberRepository;
//
//    @Test //tdd 단축 사용
//    public void testMember() throws Exception{
//     //given
//        Member member=new Member();
////        member.setUserName("memberA");
//     //when
//        Long saveId= memberRepository.save(member); //ctrl+alt+v
//        //저장된 아이디를 뽑는 역할
//
//     //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
//
//
//    }

}