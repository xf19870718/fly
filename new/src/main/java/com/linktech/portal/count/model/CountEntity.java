package com.linktech.portal.count.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class CountEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 上网累计人数
     */
    private Integer total;
    /**
     * 认证数
     */
    private Integer authSum;
    /**
     * 展示量
     */
    private Integer showSum;
    /**
     * 点击量
     */
    private Integer clickSum;
    /**
     * 独立用户数
     */
    private Integer aloneSum = 0;
    /**
     * 周
     */
    private String week;
    /**
     * 年
     */
    private String year;
    /**
     * 月
     */
    private String month;
    /**
     * 商户id
     */
    private Integer enterpriseId;
    /**
     * 商户名称
     */
    private String enterpriseName;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAuthSum() {
        return authSum;
    }

    public void setAuthSum(Integer authSum) {
        this.authSum = authSum;
    }

    public Integer getShowSum() {
        return showSum;
    }

    public void setShowSum(Integer showSum) {
        this.showSum = showSum;
    }

    public Integer getClickSum() {
        return clickSum;
    }

    public void setClickSum(Integer clickSum) {
        this.clickSum = clickSum;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Integer getAloneSum() {
        return aloneSum;
    }

    public void setAloneSum(Integer aloneSum) {
        this.aloneSum = aloneSum;
    }

}
