package com.sparta.homework01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor

public class Person extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다. autoIncreament
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;
    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String address;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private int age;

    public Person(PersonRequestDto requestDto){
        this.name=requestDto.getName();
        this.address=requestDto.getAddress();
        this.age = requestDto.getAge();

    }

    public Person(String name, String address, int age){
        this.address = address;
        this.name = name;
        this.age=age;
    }
    public void update(PersonRequestDto requestDto){
        this.name= requestDto.getName();
        this.address= requestDto.getAddress();
        this.age = requestDto.getAge();
    }
}
