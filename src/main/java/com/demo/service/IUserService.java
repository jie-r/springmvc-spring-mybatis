package com.demo.service;


import com.demo.entities.User;


/**
 * Created by Administrator on 2016/8/22.
 */
//public interface IUserService extends BaseDao<User> {

public interface IUserService {
    User getUserDataById(String id) throws Exception;

    boolean deleteUser(String id) throws Exception;

    boolean insertUserDataById(User user) throws Exception;

    User login(int id, int password) throws Exception;

    boolean updateUser(User user) throws Exception;

    boolean updateUser(String userId, String userName, String age, String cs) throws Exception;

    String selectOneC(String userId) throws Exception;

    User selectOne(String userId) throws Exception;
}
