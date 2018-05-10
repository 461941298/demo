package com.yjh.pattern.actionType.state;

/**
 * Author: yjh
 * Date: 2018/5/10 23:05
 * Desc: 水位状态
 */
public interface State {

    String describe();
}

class Shallow implements State{

    @Override
    public String describe() {
        return "低水位:水深不到2m";
    }
}

class Deep implements State{

    @Override
    public String describe() {
        return "深水位:水深超过10m";
    }
}

class Middle implements State{

    @Override
    public String describe() {
        return "中水位:水深在2m到10m之间";
    }
}



