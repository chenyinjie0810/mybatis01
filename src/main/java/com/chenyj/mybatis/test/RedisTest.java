package com.chenyj.mybatis.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisTest {
   /* public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.2.169",6379);
        jedis.auth("cyj7416146");
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        Set<String> set=jedis.keys("*");
        System.out.println(set);
    }*/


    public static void main(String[] args) {
        int i=1;
        i=i++;
        int j=i++;
        int k= i+ ++i*i++;
        System.out.println( i+"   "+j +"  " +k);
    }
}