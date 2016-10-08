package com.demo.dao;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.Map;

/**
 * BaseMapper，自己取名为BaseDao
 * Created by jie_r on 2016/9/5.
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
}
