package com.demo.dao;

import com.demo.common.Page;
import com.demo.common.Result;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/12.
 */
public class CommonDao extends SqlSessionDaoSupport {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    /**
     * 查询分页数据
     *
     * @param sqlId
     * @param page
     * @param params
     * @return
     * @throws Exception
     */
    public Result getPageList(String sqlId, Page page, Map<String, Object> params) throws Exception {
        try {
            if (page.getCurPage() <= 0) {
                page.setCurPage(1);
            }
            if (page.getRowPerPage() <= 0) {
                page.setRowPerPage(15);
            }
            PageHelper.startPage(page.getCurPage(), page.getRowPerPage(), true);
            // 排序待定
//            if(StringUtil.isNotEmpty(sort)) {
//                PageHelper.orderBy(sort);
//            }
            com.github.pagehelper.Page<?> listPage = (com.github.pagehelper.Page<?>)
                    sqlSessionFactory.openSession().selectList(sqlId, params);
            page.setTotalPages(listPage.getPages());
            page.setTotalRows(new Long(listPage.getTotal()).intValue());
            return new Result(page, listPage.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通用更新语句
     *
     * @param statementName
     * @param param
     * @return
     */
    public int updateByCondition(String statementName, Map<String, Object> param) {
        return getSqlSession().update(statementName, param);
    }

    /**
     * 返回某一列单独或所有值
     *
     * @param statementName
     * @param params
     * @return List
     */
    public List<Object> selectOneC(String statementName, Map<String, Object> params) {
        return getSqlSession().selectList(statementName, params);
    }
}
