package com.yx.domain;

import java.util.Date;

/**
 * 
 * 
 * @author licheng
 * 
 * @date 2021-02-08
 */
public class Department {
    private Integer id;

    private String name;

    private Date abatetime;

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

    public Date getAbatetime() {
        return abatetime;
    }

    public void setAbatetime(Date abatetime) {
        this.abatetime = abatetime;
    }
}