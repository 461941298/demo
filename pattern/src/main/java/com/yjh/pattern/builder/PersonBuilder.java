package com.yjh.pattern.builder;

public abstract class PersonBuilder {

    protected Person person;

    abstract void setName();

    abstract void setArms();

    public Person build() {
        setName();
        setArms();
        return person;
    }
}

class MonkeyBuilder extends PersonBuilder {

    public MonkeyBuilder() {
        this.person = new Monkey();
    }

    @Override
    void setName() {
        person.setName("孙悟空");
    }

    @Override
    void setArms() {
        person.setArms("金箍棒");
    }
}

class PigBuilder extends PersonBuilder{


    public PigBuilder() {
        this.person = new Pig();
    }

    @Override
    void setName() {
        person.setName("猪八戒");
    }

    @Override
    void setArms() {
        person.setArms("九齿钉钯");
    }
}
