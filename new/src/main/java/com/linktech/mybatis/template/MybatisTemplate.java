package com.linktech.mybatis.template;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.common.PageEntity;

import java.util.List;

@Repository
public class MybatisTemplate {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 通用添加方法
     *
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return int
     */
    public int add(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.insert(statement, parameter);
    }

    /**
     * 通用添加方法
     *
     * @param statement 查询方法
     * @return int
     */
    public int add(String statement) throws Exception {
        return sqlSessionTemplate.insert(statement);
    }

    /**
     * 通用删除方法
     *
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return int
     */
    public int delete(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.delete(statement, parameter);
    }

    /**
     * 通用删除方法
     *
     * @param statement Sql 声明Id
     * @return int
     */
    public int delete(String statement) throws Exception {
        return sqlSessionTemplate.delete(statement);
    }

    /**
     * 通用修改方法
     *
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return
     */
    public int update(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.update(statement, parameter);
    }

    /**
     * 通用修改方法
     *
     * @param statement Sql 声明Id
     * @return
     */
    public int update(String statement) throws Exception {
        return sqlSessionTemplate.update(statement);
    }

    /**
     * 通用查询方法(RowBounds)
     *
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @param rowBounds RowBounds
     * @return List
     */
    public List<?> query(String statement, Object parameter, RowBounds rowBounds) throws Exception {
        return sqlSessionTemplate.selectList(statement, parameter, rowBounds);
    }

    /**
     * 通用查询方法(多个)
     *
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return List
     */
    public List<?> queryAll(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.selectList(statement, parameter);
    }

    /**
     * 通用查询方法(多个)
     *
     * @param <T>
     * @param cls       实体类class
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return List
     */
    public <T> List<T> queryAll(Class<T> cls, String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.selectList(cls.getName() + "." + statement, parameter);
    }

    /**
     * 通用查询方法(多个)
     *
     * @param statement Sql 声明Id
     * @return List
     */
    public List<?> queryAll(String statement) throws Exception {
        return sqlSessionTemplate.selectList(statement);
    }

    /**
     * 通用查询方法(多个)
     *
     * @param <T>
     * @param cls       实体类class
     * @param statement Sql 声明Id
     * @return List
     */
    public <T> List<T> queryAll(Class<T> cls, String statement) throws Exception {
        return sqlSessionTemplate.selectList(cls.getName() + "." + statement);
    }

    /**
     * 通用查询方法(单个)
     *
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return Object
     */
    public Object queryOne(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.selectOne(statement, parameter);
    }

    /**
     * 通用查询方法(单个)
     *
     * @param <T>
     * @param cls       实体类class
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return Object
     */
    public <T> T queryOne(Class<T> cls, String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.selectOne(cls.getName() + "." + statement, parameter);
    }

    /**
     * 通用查询方法(单个)
     *
     * @param statement Sql 声明Id
     * @param parameter 条件参数
     * @return Object
     */
    public Object queryOne(String statement) throws Exception {
        return sqlSessionTemplate.selectOne(statement);
    }

    /**
     * 分页查询
     *
     * @param statement Sql 声明Id
     * @param page      分页实体类
     */
    public <T> void queryPage(String statement, PageEntity<T> page) throws Exception {
        Integer count = sqlSessionTemplate.selectOne("com.lee.Page.findTableCount", page);
        Integer pageSize = page.getPageSize();
        Integer pageNow = page.getPageNow();
        page.setStartRow((pageNow - 1) * pageSize);
        page.setTotalRows(count);
        if (count % pageSize == 0) {
            page.setPageCount(count / pageSize);
        } else {
            page.setPageCount(count / pageSize + 1);
        }
        List<T> receList = sqlSessionTemplate.selectList(statement, page);
        page.setReceList(receList);
    }

}
