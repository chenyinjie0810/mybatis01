package com.chenyj.mybatis.model;

import java.io.Serializable;
import java.util.List;

public class SpringBootDepa implements Serializable {
    private String name;

    private Integer id;

    private List<SpringBootNameModel> springBootNameModels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<SpringBootNameModel> getSpringBootNameModels() {
        return springBootNameModels;
    }

    public void setSpringBootNameModels(List<SpringBootNameModel> springBootNameModels) {
        this.springBootNameModels = springBootNameModels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SpringBootDepa{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", springBootNameModels=" + springBootNameModels +
                '}';
    }
}