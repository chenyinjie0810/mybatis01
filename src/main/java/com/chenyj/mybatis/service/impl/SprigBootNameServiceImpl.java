package com.chenyj.mybatis.service.impl;

import com.chenyj.mybatis.mapper.SpringBootNameModelMapper;
import com.chenyj.mybatis.model.SpringBootNameModel;
import com.chenyj.mybatis.service.SprigBootNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: Created by chenyj on 2019/4/12
 * @copyright 版权由上海卓繁信息技术股份有限公司拥有
 */
@Service
public class SprigBootNameServiceImpl implements SprigBootNameService {

    @Autowired
    private SpringBootNameModelMapper springBootNameModelMapper;

    @Override
    public SpringBootNameModel findNameById(Integer id) {
        return springBootNameModelMapper.findNameById(id);
    }

    @Override
    public SpringBootNameModel getNameInfoById(Integer id) {
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("id",id);
        return springBootNameModelMapper.getNameInfoById(map);
    }

    @Override
    public Map<String, Object> getName(String name) {
        return springBootNameModelMapper.getNameSByInfro(name);
    }

    @Override
    public List<SpringBootNameModel> getNameListByName(String name) {
        return springBootNameModelMapper.getNameListByName(name);
    }


}
