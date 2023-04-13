package jpabook.jpashop.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository //Component 스캔 대상이되어 자동으로 빈에 등록된다.
public class MemberRepository {
    @PersistenceContext //스프링이 엔티티 매니저를 주입해준다.
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId(); //커맨드와 쿼리를 분리하라. 아이디 조회가능
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
