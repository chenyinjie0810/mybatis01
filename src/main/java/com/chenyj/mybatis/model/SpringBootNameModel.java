package com.chenyj.mybatis.model;


import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value = "nameModel")
public class SpringBootNameModel implements Serializable {
    private Integer id;

    private String name;

    private String emil;

    private Integer depaId;

    private SpringBootDepa depa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil == null ? null : emil.trim();
    }

    public SpringBootDepa getDepa() {
        return depa;
    }

    public void setDepa(SpringBootDepa depa) {
        this.depa = depa;
    }

    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    @Override
    public String toString() {
        return "SpringBootNameModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emil='" + emil + '\'' +
                ", depaId=" + depaId +
                ", depa=" + depa +
                '}';
    }
}