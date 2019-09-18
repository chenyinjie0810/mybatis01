package com.chenyj.mybatis.service;

import com.chenyj.mybatis.model.SpringBootNameModel;

import java.util.List;
import java.util.Map;

/**
 * @description: Created by chenyj on 2019/4/12
 * @copyright 版权由上海卓繁信息技术股份有限公司拥有
 */
public interface SprigBootNameService {

    SpringBootNameModel findNameById(Integer id);

    SpringBootNameModel getNameInfoById(Integer id);

    Map<String,Object> getName(String name);

    List<SpringBootNameModel> getNameListByName(String name);
}
