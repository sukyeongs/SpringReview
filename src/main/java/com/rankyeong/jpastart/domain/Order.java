package com.rankyeong.jpastart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")    // 설정하지 않으면 order로 됨! 테이블 이름 설정
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne    // 연관관계의 주인
    @JoinColumn(name = "member_id")    // 매핑을 무엇으로 할 것이냐 → FK 이름이 member_id 가 됨
    private Member member;    // Order와 Member는 다대일 관계

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;    // 연관관계의 주인

    private LocalDateTime orderDate;    // 주문시간 (Date : 날짜 관련 annotaion 필요 / LocalDateTime 쓰면 hibernate가 알아서 지원)

    @Enumerated(EnumType.STRING)
    private OrderStatus status;    // 주문상태 [ORDER, CANCEL]
}
