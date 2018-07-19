package com.yjh.java.base;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/12 11:06
 * Version: 1.0
 * Desc:
 */
public class TestTime {

    @Test
    public void test1() throws IOException {

        //获取网络时间

        URL url = new URL("http://www.ntsc.ac.cn");
        URLConnection uc = url.openConnection();
        Long dateTime = uc.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(dateTime));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
    }

    @Test
    public void test2() {
        long dateTime = 1526094506110L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(dateTime));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));

    }
}
