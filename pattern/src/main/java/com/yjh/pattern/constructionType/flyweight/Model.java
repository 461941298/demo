package com.yjh.pattern.constructionType.flyweight;

public interface Model {

    void wear(Clothes clothes);
}

class ProfessionalModel implements Model {

    private String name;

    public ProfessionalModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void wear(Clothes clothes) {
        System.out.println("这是专业模特: " + name + " 穿着 " + clothes.getName() + " 衣服");
    }
}

class Tramp implements Model {

    private String name;

    public Tramp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void wear(Clothes clothes) {
        System.out.println("这是流浪汉: " + name + " 穿着 " + clothes.getName() + " 衣服");
    }
}
