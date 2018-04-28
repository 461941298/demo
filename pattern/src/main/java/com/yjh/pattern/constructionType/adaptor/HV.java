package com.yjh.pattern.constructionType.adaptor;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 15:00
 * Version: 1.0
 * Desc: 高电压
 */
public class HV {

    public Long output() {
        System.out.println("高电压 10000V ");
        return 10000L;
    }
}

interface LV {

    Integer outputLV();
}

class Adaptor extends HV implements LV {

    @Override
    public Integer outputLV() {
        Long v = output();
        Integer lv = (int) (v / 100);
        System.out.println("适配器将高电压变为低电压...");
        return lv;
    }
}