package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
    @Id @GeneratedValue
    @Column (name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    //양방향 연관관계 , 관계의 주인을 정해야 한다.
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems=new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //일대일 관계일때 외래키는 자주 참조해 확인하는 order에서 한다
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;//주문시간
    //자바 8에서는 하이버네이트가 LocalDateTime 지원하고 있다.

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]
}
