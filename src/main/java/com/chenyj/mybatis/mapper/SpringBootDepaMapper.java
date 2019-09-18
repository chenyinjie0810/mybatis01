package com.chenyj.mybatis.mapper;

import com.chenyj.mybatis.model.SpringBootDepa;

import java.util.List;

import com.chenyj.mybatis.model.SpringBootNameModel;
import org.apache.ibatis.annotations.Param;

public interface SpringBootDepaMapper {


    int insert(SpringBootDepa record);

    int insertSelective(SpringBootDepa record);

    SpringBootDepa findDepaById(Integer id);

    List<SpringBootDepa> findDepaByName(String name);

    List<SpringBootDepa> findDepasById(Integer id);

}