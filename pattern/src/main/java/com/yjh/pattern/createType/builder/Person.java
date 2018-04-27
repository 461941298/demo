package com.yjh.pattern.createType.builder;

public abstract class Person {

    protected String name;
    protected String arms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", arms='" + arms + '\'' +
                '}';
    }
}

class Monkey extends Person{

}

class Pig extends Person{

}
