package com.demo.dao;

import com.demo.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * userDao
 * 继承BaseDao
 * 自定义一些sql操作
 */
public interface UserDao extends BaseDao<User> {
    /**
     * 登陆
     *
     * @param id
     * @param password
     * @return
     */
    User login(@Param("id") int id, @Param("password") int password);

    /**
     * 可以使用sql别名, map的键值对则为取得别名
     *
     * @param keyword
     * @return
     */
    List<Map> loadUserInfo(@Param("keyword") String keyword);

    void updatePwd(Map<String, Object> parameterMap);
}
