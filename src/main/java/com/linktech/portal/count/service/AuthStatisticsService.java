package com.linktech.portal.count.service;

import com.linktech.mybatis.model.BeAuthStatistics;
import com.linktech.mybatis.template.MybatisTemplate;
import com.linktech.portal.count.model.CountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthStatisticsService {

    @Autowired
    protected MybatisTemplate mybatisTemplate;

    public List<BeAuthStatistics> findForEnterprise(String startTime, String endTime, Integer pageNow, Integer pageSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer startRow = (pageNow - 1) * pageSize;
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("startRow", startRow);
        map.put("pageSize", pageSize);
        return mybatisTemplate.queryAll(BeAuthStatistics.class, "findForEnterprise", map);
    }

    public BeAuthStatistics findForDate(String startTime, String endTime) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return mybatisTemplate.queryOne(BeAuthStatistics.class, "findForDate", map);
    }

    public List<BeAuthStatistics> findForDay(String startTime, String endTime) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return mybatisTemplate.queryAll(BeAuthStatistics.class, "findForDay", map);
    }

    @SuppressWarnings("unchecked")
    public List<CountEntity> findForWeek(String startTime, String endTime) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return (List<CountEntity>) mybatisTemplate.queryAll("com.linktech.mybatis.model.BeAuthStatistics.findForWeek", map);
    }

    @SuppressWarnings("unchecked")
    public List<CountEntity> findForMonth(String startTime, String endTime) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return (List<CountEntity>) mybatisTemplate.queryAll("com.linktech.mybatis.model.BeAuthStatistics.findForMonth", map);
    }

    @SuppressWarnings("unchecked")
    public List<CountEntity> findForYear(String startTime, String endTime) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return (List<CountEntity>) mybatisTemplate.queryAll("com.linktech.mybatis.model.BeAuthStatistics.findForYear", map);
    }

    @SuppressWarnings("unchecked")
    public List<CountEntity> findForEnterpriseTime(Integer enterpriseId, String startTime, String endTime, String format) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("enterpriseId", enterpriseId);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("format", format);
        return (List<CountEntity>) mybatisTemplate.queryAll("com.linktech.mybatis.model.BeAuthStatistics.findForEnterpriseTime", map);
    }

}
