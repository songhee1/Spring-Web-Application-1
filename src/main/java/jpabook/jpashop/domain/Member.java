package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
//실무에서는 Getter을 호출할 일이 많으므로 Getter을 열어두는게 좋고, Setter는
//변경지점이 명확하도록 변경을 위한 비즈니스 메서드를 제공해야 한다.
public class Member {
    @Id @GeneratedValue
    @Column (name="member_id")
    //테이블에서는 명확하게 클래스 이름을 넣어서 작성(테이블명_id)(member_id)
    private Long id;

    private String name;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    // 나는 연관관계 주인이 아닙니다를 의미
    //member에 의해 매핑된 정보임을 의미한다.

    private List<Order> orders= new ArrayList<>();
    //한 명의 회원이 여러 개의 주문을 하기 때문에 일대다 관계
    //외래키는 하나다. Order도 멤버를 가지고 있다. 양방향 참조
    //값이 변경되었을때 어떻게 해야하는가?
    //주인은 외래키와 가까운 곳으로, Order에 있는 Member을 연관관계 주인으로 하면 된다. 해당 컬럼 값이 변경되면 업데이트된다.

}
