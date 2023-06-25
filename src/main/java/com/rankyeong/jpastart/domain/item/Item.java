package com.rankyeong.jpastart.domain.item;

import com.rankyeong.jpastart.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")    // ex. BOOK이면 어떤어떤 필드가 존재한다!
@Getter @Setter
public abstract class Item {    // 구현체를 갖고 시작할 것 → abstract

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
