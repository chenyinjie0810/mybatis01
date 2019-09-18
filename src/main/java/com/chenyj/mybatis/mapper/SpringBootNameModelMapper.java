package com.chenyj.mybatis.mapper;

import com.chenyj.mybatis.model.SpringBootDepa;
import com.chenyj.mybatis.model.SpringBootNameModel;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpringBootNameModelMapper {
    int insert(SpringBootNameModel record);

    int insertSelective(SpringBootNameModel record);

    SpringBootNameModel getNameInfoById(Map map);

    @MapKey("id")
    Map<String,Object> getNameSByInfro(String name);

    List<SpringBootNameModel> getNameListByName(String name);

    SpringBootNameModel findNameById(Integer id);

    List<SpringBootNameModel> findNameByInfo(SpringBootNameModel nameModel);


    List<SpringBootNameModel> findNameByListIDs(@Param("ids") List<Integer> list);
}
