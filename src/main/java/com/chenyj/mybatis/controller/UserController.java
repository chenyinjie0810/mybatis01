package com.chenyj.mybatis.controller;

import com.chenyj.mybatis.mapper.SpringBootDepaMapper;
import com.chenyj.mybatis.mapper.SpringBootNameModelMapper;
import com.chenyj.mybatis.model.SpringBootDepa;
import com.chenyj.mybatis.model.SpringBootNameModel;
import com.chenyj.mybatis.service.SprigBootNameService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {


    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SprigBootNameService sprigBootNameService;
    @Autowired
    private SpringBootNameModelMapper springBootNameModelMapper;
    @Autowired
    private SpringBootDepaMapper springBootDepaMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getNameInfo/{id}")
    @ResponseBody
    public SpringBootNameModel getNameInfo(@PathVariable("id")Integer id){
        logger.info("输入参数："+id);
        SpringBootNameModel springBootNameModel=sprigBootNameService.getNameInfoById(id);
        return springBootNameModel;
    }


    @GetMapping("/getNameByName/{name}")
    @ResponseBody
    public String getName(@PathVariable("name")String name){
        return sprigBootNameService.getName(name).toString();
    }

    @ResponseBody
    @GetMapping("/findNameById/{id}")
    public String findNameById(@PathVariable("id") Integer id){
        SpringBootNameModel springBootNameModel=sprigBootNameService.findNameById(id);
        System.out.println(springBootNameModel.getName());
        return springBootNameModel.toString();
    }

    @ResponseBody
    @GetMapping("/findDepaByName/{name}/{id}")
    public String findDepaByName(@PathVariable("name") String name,@PathVariable("id") Integer id){
        PageHelper.startPage(1, 3);
        List<SpringBootDepa> depas=springBootDepaMapper.findDepaByName(name);
        PageInfo<SpringBootDepa> pageInfo = new PageInfo<>(depas);
//        List<SpringBootDepa> depas=springBootDepaMapper.findDepasById(id);

        return depas.toString();
    };

    @ResponseBody
    @GetMapping("/findNameByInfo/{id}/{name}/{emil}")
    public String findNameByInfo(SpringBootNameModel nameModel){
        List<SpringBootNameModel> list=springBootNameModelMapper.findNameByInfo(nameModel);
        List<SpringBootNameModel> list01=springBootNameModelMapper.findNameByInfo(nameModel);
        System.out.println(list==list01);
        return list.toString();
    }

    @ResponseBody
    @GetMapping("findNameByListIDs/{id1}/{id2}/{id3}")
    public String findNameByListIDs(@PathVariable("id1") Integer id1,@PathVariable("id2")Integer id2,
                                    @PathVariable("id3")Integer id3){
        List<Integer> list=new ArrayList<>();
        list.add(id1);
        list.add(id2);
        list.add(id3);
        List<SpringBootNameModel> springBootNameModels=springBootNameModelMapper.findNameByListIDs(list);
        return springBootNameModels.toString();
    }


    @Autowired
    RedisConnectionFactory factory;

    @ResponseBody
    @GetMapping("findRedis/{name}")
    public String findRedis(SpringBootNameModel nameMode){
        List<SpringBootNameModel> list=springBootNameModelMapper.findNameByInfo(nameMode);
        stringRedisTemplate.opsForValue().set("chenyj",list.toString());
        stringRedisTemplate.opsForValue().set("chenyj","chenyj");
        logger.info("返回参数："+stringRedisTemplate.opsForValue().get("chenyj"));
       return stringRedisTemplate.opsForValue().get("chenyj");
    }


}
