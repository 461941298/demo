package com.yjh.pattern.createType.factory.factoryMethod;


public interface Factory {

    Person getPerson();
}

class MonkeyFactory implements Factory {

    @Override
    public Person getPerson() {
        return new Monkey();
    }
}

class PigFactory implements Factory {

    @Override
    public Person getPerson() {
        return new Pig();
    }
}