package com.fursys.demo.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    /**
     *  값 타입은 immutable 해야 한다. 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들어야 한다.
     */

    private String city;
    private String street;
    private String zipcode;

    /**
     *  JPA가 기본 생성자를 만들도록 제약을 두는 이유는 JPA 구현 라이브러리가 객체를 생성할 때 리플렉션, 프록시 같은 기술을 사용할 수 있도록 지원해야 하기 때문이다.
     */
    protected Address() {}

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }


}
