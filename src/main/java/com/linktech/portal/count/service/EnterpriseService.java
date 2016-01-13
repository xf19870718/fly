package com.linktech.portal.count.service;

import com.linktech.mybatis.model.BeEnterprise;
import com.linktech.mybatis.template.MybatisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商户Service
 */
@Service
public class EnterpriseService {

    @Autowired
    protected MybatisTemplate mybatisTemplate;

    /**
     * 查询全部商户
     *
     * @return List<BeEnterprise>
     */
    public List<BeEnterprise> findAll() throws Exception {
        return mybatisTemplate.queryAll(BeEnterprise.class, "findAll");
    }

}
