package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    //값은 변경되어서는 안된다. setter을 제공하지 않으면 변경이 불가능하게 된다.

    protected Address(){//기본 생성자만들도록 되어있다.
    }//jpa 스펙상 만들어둔 것으로, 함부로 new로 만들면 안되겠다는 의미
    //임베디드 타입은 기본 생성자를 public 또는 protected로 설정하도록 jpa에서 제약을 두고 있다.
    //jpa 구현 라이브러리가 객체 생성시 기술을 사용할 수 있도록 지원해야 하기 때문

    public Address(String city, String street, String zipcode){
        this.city=city;
        this.street=street;
        this.zipcode=zipcode;
    }
}
