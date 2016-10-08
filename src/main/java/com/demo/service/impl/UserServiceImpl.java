package com.demo.service.impl;

import com.demo.common.enums.UserStatus;
import com.demo.common.Page;
import com.demo.common.Result;
import com.demo.common.util.StringUtil;
import com.demo.dao.UserDao;
import com.demo.entities.User;
import com.demo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户
 * Created by Administrator on 2016/8/22.
 */
@Transactional
@Service
public class UserServiceImpl extends BaseService implements IUserService {
    @Resource
    private UserDao userDao;

    /**
     * 分页查询，插件使用PageHelper，见https://github.com/pagehelper/Mybatis-PageHelper
     *
     * @param curPage
     * @param keyword
     * @return
     * @throws Exception
     */
    public Result loadAuditUser(int curPage, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(keyword)) {
            keyword = "%" + keyword + "%";
        }
        map.put("keyword", keyword);
        Page page = new Page(curPage, 15);
        Result result = super.commonDao.getPageList("loadUserAudit", page, map);
        return result;
    }

    /**
     * 根据主键查询数据，返回对象，根据userDao中注入的实体对象决定
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User getUserDataById(String id) throws Exception {
        int i = 1 / 0;
        User user = userDao.selectByPrimaryKey(Integer.parseInt(id));
        return user;
    }

    /**
     * 调用存储过程
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean updatePwd(String userId) throws Exception {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        // 定义入参
        parameterMap.put("userId", userId);
        // 定义出参
        parameterMap.put("returnVal", "");
        userDao.updatePwd(parameterMap);
        String returnVal = parameterMap.get("returnVal").toString();
        if (("1").equals(returnVal) || ("0").equals(returnVal)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据逐渐删除数据
     * Propagation.NOT_SUPPORTED 设置不支持事物
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public boolean deleteUser(String id) throws Exception {
        return userDao.deleteByPrimaryKey(Integer.parseInt(id)) == 1 ? true : false;
    }

    /**
     * insert 插入对象，此方法会根据实体属性挨个插入，不管是否为空
     * insertSelective 插入对象，此方法会选择性的插入，为空不插入
     * insertUseGeneratedKeys 插入对象，此方法会返回生成的id值
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean insertUserDataById(User user) throws Exception {
        user.setPassword("111");
        user.setStatus(UserStatus.SUCCSE);
        user.setDate(new Date());
        return userDao.insert(user) == 1 ? true : false;
    }

    /**
     * 查询表中某些固定列数据，返回map
     *
     * @param keyword
     * @return
     */
    public List<Map> loadUserInfo(String keyword) throws Exception {
        if (StringUtil.isNotEmpty(keyword)) {
            keyword = "%" + keyword + "%";
        }
        return userDao.loadUserInfo(keyword);
    }

    public User login(int id, int password) throws Exception {
        return userDao.login(id, password);
    }

    /**
     * updateByPrimaryKeySelective 根据主键选择性更新数据
     * updateByExample 以Example对象为条件，更新数据
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean updateUser(User user) throws Exception {
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("name", "test");
//        userDao.updateByExample(user, example);
        userDao.updateByPrimaryKeySelective(user);
        return true;
    }

    /**
     * select 根据实体查询
     * selectByExample 根据Example查询数据
     * 更多方法用法可自行研究
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public User selectOne(String userId) throws Exception {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("sex", userId);
        return userDao.selectByExample(example).get(0);
    }

    /**
     * 通用更新语句组装
     *
     * @param userId
     * @param userName
     * @param age
     * @param cs
     * @return
     * @throws Exception
     */
    public boolean updateUser(String userId, String userName, String age, String cs) throws Exception {
        // 组装修改的值
        Map<String, Object> relationMap = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(userName)) {
            relationMap.put("name", userName);
        }
        if (StringUtil.isNotEmpty(age)) {
            relationMap.put("age", age);
        }
        if (StringUtil.isNotEmpty(cs)) {
            relationMap.put("cs", Boolean.parseBoolean(cs));
        }

        // 组装条件
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("id", Integer.parseInt(userId));
        conditionMap.put("password", "111");

        // 组装参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("relationMap", relationMap);
        params.put("conditionMap", conditionMap);
        params.put("tableName", "user");
        return super.commonDao.updateByCondition("com.demo.dao.CommonMapper.updateByCondition", params) == 1 ? true : false;
    }

    /**
     * 根据条件查询一个值
     *
     * @param userId
     * @return
     */
    public String selectOneC(String userId) {
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("id", Integer.parseInt(userId));

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("conditionMap", conditionMap);
        params.put("tableName", "user");
        params.put("columnName", "name");
        List list = super.commonDao.selectOneC("com.demo.dao.CommonMapper.selectSingleColumn", params);
        return (String) list.get(0);
    }
}
