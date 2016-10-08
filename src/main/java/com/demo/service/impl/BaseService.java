package com.demo.service.impl;

import com.demo.dao.CommonDao;

import javax.annotation.Resource;

/**
 * 基础service
 *
 * @Created by lj on 2016/9/13.
 */
public class BaseService {
    /**
     * 通用更新语句sqlID
     */
    private final static String COMMONMAPPER_UPDATEBYCONDITION = "com.demo.dao.CommonMapper.updateByCondition";

    /**
     * 通用查询语句ID
     */
    private final static String COMMONMAPPER_SELECTSINGLECOLUMN = "com.demo.dao.CommonMapper.selectSingleColumn";

    /**
     * 通用公共Dao
     */
    @Resource
    public CommonDao commonDao;
}
