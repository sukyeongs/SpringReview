package com.rankyeong.jpastart.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable    // JPA의 내장타입 → 어딘가에 내장이 될 수 있음
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
