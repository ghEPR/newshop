package com.gh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author finally
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PutMapping("")
    public Map<String,Object> setKey(String key,String value){

        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(key);
        boundValueOperations.set(value);
        Map<String,Object> map = new HashMap<>();
        map.put("redisCode",1);
        map.put("redisMessage","添加成功");
        return map;

    }

    @GetMapping("")
    public Map<String,Object> getKey(String key){

        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(key);
        String value = (String) boundValueOperations.get();
        Map<String,Object> map = new HashMap<>();
        map.put("redisCode",1);
        map.put("redisMessage","获取成功");
        map.put("result", value);
        return map;

    }
}
