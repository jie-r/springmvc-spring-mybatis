package com.demo.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/13.
 */
@MappedSuperclass
public class baseEntity {
    /**
     * 实体ID
     */
    @Id
    private int id;

    /**
     * 更新时间
     */
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
