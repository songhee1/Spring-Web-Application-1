package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //스프링 빈에 등록되어 컴포넌트 스캔 대상이 된다.
@Transactional(readOnly = true) //기본적으로 트랜잭션 안에서 동작한다. public메서드들이 트랜잭션에 걸리게 된다.
public class MemberService {

    @Autowired //스프링이 리포지토리를 인젝션
    private MemberRepository memberRepository;

    /*
    *회원 가입(핵심기능)
    **/
    @Transactional //쓰기 : readOnly=false가 적용
    public Long join(Member member){
        validateDuplicateMember(member); //중복회원 방지 검증
        memberRepository.save(member);
        return member.getId(); //아이디값을 준다.
    }
    private void validateDuplicateMember(Member member){
        //EXCEPTION 문제가 있으면 예외 터트린다.
        List<Member> findMembers=memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    //회원 전체 조회(핵심기능)
     //읽기에는 readOnly=true
    public List<Member> findMember(){
        return memberRepository.findAll(); //멤버 전체 조회
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
