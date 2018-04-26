package com.yjh.pattern.builder;

public class Director {

    private PersonBuilder personBuilder;

    public Director(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public Person getPerson() {
        return personBuilder.build();
    }
}
