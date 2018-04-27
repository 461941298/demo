package com.yjh.pattern.builder;

public class Director {

    private PersonBuilder personBuilder;

    public Director(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public Person getPerson() {
        personBuilder.setName();
        personBuilder.setArms();
        return personBuilder.build();
    }
}
