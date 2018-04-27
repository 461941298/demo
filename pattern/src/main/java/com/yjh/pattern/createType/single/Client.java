package com.yjh.pattern.createType.single;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/26 16:30
 * Version: 1.0
 * Desc:
 */
public class Client {

    private void commonCode(List list){
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i));
            System.out.println(list.get(i + 1));
            System.out.println(list.get(i) == list.get(i + 1));
            System.out.println("==========");
        }
    }

    @Test
    public void test1() throws InterruptedException {
        List<Person1> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    () -> list.add(Person1.createPerson())
            ).start();
        }
        Thread.sleep(3000L);
        commonCode(list);
    }

    @Test
    public void test2() throws InterruptedException {
        List<Person2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    () -> list.add(Person2.createPerson())
            ).start();
        }
        Thread.sleep(3000L);
        commonCode(list);
    }

    @Test
    public void test3() throws InterruptedException {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    () -> list.add(Person3.PERSON_3.getPerson())
            ).start();
        }
        Thread.sleep(3000L);
        commonCode(list);
    }
}

class Person {

}

//懒汉模式
class Person1 {
    private static Person1 person;

    private Person1() {
    }

    public synchronized static Person1 createPerson() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null == person) {
            person = new Person1();
        }
        return person;
    }
}

//饥汉模式
class Person2 {
    private static Person2 person = new Person2();

    private Person2() {
    }

    public synchronized static Person2 createPerson() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return person;
    }
}

//枚举模式
enum Person3 {
    PERSON_3(new Person());

    private Person person;

    Person3(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
