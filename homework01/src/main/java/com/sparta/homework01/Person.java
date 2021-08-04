package com.sparta.homework01;

public class Person {
    private String name;
    private String address;
    private int age;
    public Person(){

    }
    public void setName(String name){
        this.name=name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public int getAge(){
        return this.age;
    }
}
