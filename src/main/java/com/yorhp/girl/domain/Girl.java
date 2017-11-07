package com.yorhp.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String cupSize;

    @Min(value = 10,message = "未成年少女禁止入内")
    private Integer age;

    public Girl(String name, String cupSize, Integer age) {
        this.name = name;
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl(Integer id, String name, String cupSize, Integer age) {
        this.id = id;
        this.name = name;
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl() {
    }

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
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
