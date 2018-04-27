package com.yjh.java.base;

import org.junit.Test;

public class Client {

    @Test
    public void test1(){

        //学生不能.出say(),说明父类的静态方法是不能被子类继承的
        new Student();
    }
}

class Person{

    public static void say(){
        System.out.println("这是一个人");
    }
}

class Student extends Person{

}