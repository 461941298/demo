package com.yjh.pattern.createType.prototype;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 9:45
 * Version: 1.0
 * Desc: 原型模式
 */
public class Client {

    /**
     * 工厂方法, 建造者方法都可以生产复杂对象
     * 如果一个对象的生产过程非常消耗资源,那么就应该考虑使用原型模式(克隆)来创建这一对象了
     * 原型模式通常与工厂模式一起使用
     */

    @Test
    public void test() {

        Person person = new Person();
        person.setName("yjh");
        System.out.println("原始person:" + person);

        Person clone = person.clone();
        System.out.println("克隆person:" + clone);

        System.out.println("原始 person 与 clone 是否是一个:" + (person == clone));

        Student student = new Student();
        student.setName("cury");
        student.setId(1L);
        System.out.println("原始学生:" + student);

        System.out.println("克隆学生:" + student.clone());

        Team team = new Team();
        team.setPerson(person);
        System.out.println("原始team:" + team);
        Team cloneTeam = team.clone();
        System.out.println("克隆team:" + cloneTeam);

        team.setCoach(new Coach("Li"));

        cloneTeam = team.clone();
        System.out.println("赋值教练后的克隆team:" + cloneTeam);

    }


}

class Person implements Cloneable {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Student extends Person {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id + ";" +
                "name=" + name +
                '}';
    }
}

class Coach {

    private String name;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Team implements Cloneable {

    private Person person;
    private Coach coach;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Team{" +
                "person=" + person + ";" +
                "coach=" + coach +
                '}';
    }

    @Override
    public Team clone() {
        try {
            return (Team) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}