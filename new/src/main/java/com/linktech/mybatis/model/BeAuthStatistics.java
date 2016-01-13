package com.linktech.mybatis.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证统计表
 */
public class BeAuthStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 商户id
     */
    private Integer enterpriseId;
    /**
     * 商户名称
     */
    private String enterpriseName;
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
     * ubnt数据
     */
    private Integer ubntId;
    /**
     * 日期
     */
    private Date countDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUbntId() {
        return ubntId;
    }

    public void setUbntId(Integer ubntId) {
        this.ubntId = ubntId;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BeAuthStatistics");
        sb.append("{id=").append(id);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", total=").append(total);
        sb.append(", authSum=").append(authSum);
        sb.append(", showSum=").append(showSum);
        sb.append(", clickSum=").append(clickSum);
        sb.append(", ubntId=").append(ubntId);
        sb.append(", countDate=").append(countDate);
        sb.append('}');
        return sb.toString();
    }

}