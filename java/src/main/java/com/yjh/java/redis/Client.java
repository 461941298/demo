package com.yjh.java.redis;

import redis.clients.jedis.Jedis;

public class Client {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.190");
        System.out.println(jedis.ping());
        jedis.set("name", "yjh");
        System.out.println(jedis.get("name"));
    }
}
