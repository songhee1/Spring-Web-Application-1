package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //스프링 빈에 등록된다. 컴포넌트 스캔의 대상이 된다.
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;
    //스프링이 엔티티 매니저를 만들어서 injection해준다.

    public void save(Member member){
        em.persist(member);
        //영속성 컨텍스트에 멤버 객체를 올리는 단계
        //db에 insert쿼리가 날라간다.
        //회원 저장
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
        //멤버를 찾아서 반환하게 된다.
        //두번째 인자에 기본키를 작성한다.
    }

    public List<Member> findAll(){//전부다 찾아야한다. jpql 사용, 두번째 인자로 반환타입
       List<Member> result= em.createQuery("select m from Member m", Member.class)
               //from의 대상은 엔티티로, '엔티티 Member'를 조회하라는 의미다.
               .getResultList();
       return result;
       //조회 결과 반환
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name=:name, Member.class")
                .setParameter("name",name)
                .getResultList();
    }
}
