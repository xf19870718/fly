package com.linktech.mybatis.model;

import java.io.Serializable;

/**
 * 商户表
 */
public class BeEnterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户ID
     */
    private Integer id;
    /**
     * 企业所属渠道ID
     */
    private String channelId;
    /**
     * 商户名称
     */
    private String name;
    /**
     *
     */
    private String onecategory;
    /**
     *
     */
    private String twocategory;
    /**
     * 省
     */
    private Integer province;
    /**
     * 市
     */
    private Integer city;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除状态 0：正常 1：删除
     */
    private Integer delFlag;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     *
     */
    private Integer updateTime;
    /**
     * 创建人
     */
    private String createUserId;
    /**
     *
     */
    private String updateUserId;
    /**
     * 认证类型：1、一键登录;2、静态密码登录；3、免签登录；4、短信验证；
     */
    private Integer authType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnecategory() {
        return onecategory;
    }

    public void setOnecategory(String onecategory) {
        this.onecategory = onecategory;
    }

    public String getTwocategory() {
        return twocategory;
    }

    public void setTwocategory(String twocategory) {
        this.twocategory = twocategory;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

}