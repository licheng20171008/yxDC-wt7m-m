package com.yx.domain;

import java.util.Date;

/**
 * 
 * 
 * @author licheng
 * 
 * @date 2021-02-08
 */
public class Category {
    private Integer id;

    private String categoryname;

    private Date abatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Date getAbatetime() {
        return abatetime;
    }

    public void setAbatetime(Date abatetime) {
        this.abatetime = abatetime;
    }
}