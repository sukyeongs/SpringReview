package com.rankyeong.jpastart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue    // GeneratedValue : Sequence value 사용
    @Column(name = "member_id")    // 그냥 놓으면 id 로 설정됨. @Column: 컬럼 이름 지정 가능
    private Long id;

    private String name;

    @Embedded    // 내장 타입을 사용했다는 의미
    private Address address;

    @OneToMany(mappedBy = "member")    // 한 사람이 여러 상품 주문 (연관관계 주인 X → 추가 설정 필요(Mappedby))
    // Order 테이블의 member 필드에 의해 매핑 된 것 = 읽기 전용 = 이 값을 변경한다고 해서 FK 변경되지 않음
    private List<Order> orders = new ArrayList<>();
}
