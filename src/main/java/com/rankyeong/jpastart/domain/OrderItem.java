package com.rankyeong.jpastart.domain;

import com.rankyeong.jpastart.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)    // 양방향 연관관계
    @JoinColumn(name = "order_id")    // Order 하나에 여러 Order item 가능, 반대로 OrderItem은 하나의 Order만 가질 수 있음
    private Order order;

    private int orderPrice;    // 주문 가격(상품 가격 X)
    private int count;    // 주문 수량
}
