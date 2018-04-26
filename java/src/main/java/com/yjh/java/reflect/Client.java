package com.yjh.java.reflect;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.notification.StoppedByUserException;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/26 10:05
 * Version: 1.0
 * Desc: 反射学习
 */
public class Client {

    /**
     * 获取 class 的三种方法
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void test1() throws ClassNotFoundException {

        //通过对象的 getClass（）
        Person p = new Person();
        Class pClass1 = p.getClass();

        //通过类的 .clas
        Class pClass2 = Person.class;

        //通过全类名(最常用)
        Class pClass3 = Class.forName("com.yjh.java.reflect.Person");

        //class对象只有一份，所以理论上来说 三个Class对象都是同一个对象，即 pClass1 == pClass2 == pClass3
        System.out.println("三个Class对象都是同一个对象 ： " + ((pClass1 == pClass2) && (pClass2 == pClass3)));
    }

    /**
     * 初步认识
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class pClass = Class.forName("com.yjh.java.reflect.Person");
        Class sClass = Class.forName("com.yjh.java.reflect.Student");
        Student student = new Student(1L, "cury", 30);

        //asSubclass(Class zlass), 将当前对象转换成括号中指定对象的一个子类，如果转换不成会出异常
        System.out.println(" 将Student 作为 Persion 的一个子类 ：" + sClass.asSubclass(pClass));

        //打印包名
        System.out.println(pClass.getPackage());

        //getFields() 只返回 修饰符为 public 的成员变量
        System.out.println(pClass.getFields().length); // 输出 1 ; 因为 name 是 public
        System.out.println(pClass.getField("name"));

        //getDeclaredFields() 返加所有成员变量
        System.out.println(pClass.getDeclaredFields().length);

        //getMethods() 会获取父类方法
        System.out.println(pClass.getMethods()[0].toString());

    }

    /**
     * 获取 成员变量， 方法， 构造方法
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void test3() throws ClassNotFoundException {
        Class pClass = Class.forName("com.yjh.java.reflect.Person");

        List<Field> fields = Arrays.asList(pClass.getDeclaredFields());
        for (Field f : fields) {
            System.out.println(f.toString());
        }

        System.out.println("==========");

        List<Method> methods = Arrays.asList(pClass.getDeclaredMethods());
        for (Method m : methods) {
            System.out.println(m.toString());
        }

        System.out.println("==========");

        List<Constructor> constructors = Arrays.asList(pClass.getConstructors());
        for (Constructor c : constructors) {
            System.out.println(c.toString());
        }
    }

    /**
     * 构造对象 和 方法 invoke
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void test4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class pClass = Class.forName("com.yjh.java.reflect.Person");

        //第一种构建方法
        Person person1 = (Person) pClass.newInstance();
        person1.setName("张三");
        person1.setAge(10);
        System.out.println("person1 : " + person1);

        //第二种构建方法
        Constructor constructor = pClass.getDeclaredConstructor(String.class, Integer.class);
        Person person2 = (Person) constructor.newInstance("张三", 11);
        System.out.println("person2 : " + person2);

        //方法调用
        Method method = pClass.getDeclaredMethod("setName", String.class);
        method.invoke(person2, "李四");
        System.out.println("反射方法调用后的 person2 ：" + person2);

    }

    /**
     * 处理反射中的 泛型
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void test5() throws NoSuchMethodException {

        // java反射在泛型这块定义了如下几个类型
        // 1.ParameterizedType:表示一种参数化的类型，比如Collection< String >
        // 2.GenericArrayType:表示一种元素类型是参数化类型或者类型变量的数组类型
        // 3.TypeVariable:是各种类型变量的公共父接口
        // 4.WildcardType:代表一种通配符类型表达式，比如？、？ extends Number、？ super Integer。（wildcard是一个单词：就是”通配符“）
        // 在 Person 类中 有一个 test 方法, 参数和返回值都是有泛型

        // Method/Constructor/Field/Element 都继承了 AccessibleObject , AccessibleObject 类中有一个 setAccessible 方法:
        // public void setAccessible(booleanflag)throws SecurityException{
        //    ...
        // }
        // 该方法有两个作用:
        // 启用/禁用访问安全检查开关:值为true,则指示反射的对象在使用时取消Java语言访问检查; 值为false,则指示应该实施Java语言的访问检查;
        // 可以禁止安全检查, 提高反射的运行效率.

        Class pClass = Person.class;
        Method method = pClass.getDeclaredMethod("test", Map.class, List.class);
        method.setAccessible(false); //设置访问时不进行全安检查

        //获取方法参数类型 Map<String, Person> map, List<Person> list;
        Type[] parameterTypes = method.getGenericParameterTypes();
        for (Type paramType : parameterTypes) {

            if (paramType instanceof ParameterizedType) { //如果参数类型是一个泛型类型
                //获取泛型中的具体类型
                Type[] actualTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                for (Type type : actualTypes) {
                    System.out.println(type);
                }
            }
        }
        
        System.out.println("==========");

        //获取返回值类型
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {

            Type[] actualTypes = ((ParameterizedType) returnType).getActualTypeArguments();

            for (Type type : actualTypes) {
                System.out.println(type);
            }
        }
    }


}

class Person {
    public String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Map<String, Person> test(Map<String, Person> map, List<Person> list) {
        System.out.println(list);
        return map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

class Student extends Person {

    private Long id;

    public Student() {
    }

    public Student(Long id, String name, Integer age) {
        super(name, age);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
