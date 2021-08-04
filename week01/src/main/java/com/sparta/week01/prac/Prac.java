package com.sparta.week01.prac;

public class Prac {

    public static void main(String[] args) {
        Course course = new Course();
        course.setTitle("웹개발의 봄, Spring");
        course.setTutor("남병관");
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());

        Course course2 = new Course("자료구조", "강전호", 3);

        System.out.println(course2.getTitle());
        System.out.println(course2.getTutor());
        System.out.println(course2.getDays());
    }
}
