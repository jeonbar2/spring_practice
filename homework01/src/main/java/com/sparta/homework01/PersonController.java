package com.sparta.homework01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/myinfo")
    public Person getPerson(){
        Person person = new Person();
        person.setName("강전호");
        person.setAddress("부천시");
        person.setAge(27);
        return person;
    }
}
