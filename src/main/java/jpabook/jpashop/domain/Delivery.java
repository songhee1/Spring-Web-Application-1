package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    //내장타입
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    //이넘 타일 쓸때 사용하는 어노테이션
    //EnumType.ORDINAL 은 절대 쓰면 안돼고 무조건 String을 써야 한다.
    private DeliveryStatus status;
}
