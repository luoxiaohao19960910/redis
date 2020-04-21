package com.springboot.redis;

import com.springboot.redis.pojo.User;
import com.springboot.redis.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;


    //使用原生的api过于复杂，使用封装好的RedisTemplate工具类
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {

        User user = new User(2L,"李四",18,new Date());
//        redisTemplate.opsForValue().set("user",user);
//        System.out.println(redisTemplate.opsForValue().get("user"));

        redisUtil.set("luoxiaohao:test:user2",user);
        System.out.println(redisUtil.get("luoxiaohao:test:user2"));

        redisUtil.expire("user",30);

    }

}
