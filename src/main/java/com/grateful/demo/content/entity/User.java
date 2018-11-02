package com.grateful.demo.content.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.grateful.demo.content.enums.SexEnum;
import com.grateful.demo.frameWork.config.EnumJsonSerializer;
import com.grateful.demo.frameWork.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * user实体
 */
public class User implements Serializable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 账户名
     */
    private String accountName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 出生日期
     */
    private Date birth = DateUtils.getCurrentDateTime();

    /**
     * 性别
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private SexEnum sex = SexEnum.Male;

//    private Integer sex = 0;

    /**
     * 年龄
     */
    private Integer age = 0;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 住址
     */
    private String address;

    /**
     * 角色类型
     */
    private Integer roleType = 0;

    /**
     * 排序号
     */
    private Integer rank = 0;

    /**
     * 冻结标志
     */
    private Boolean frozen = Boolean.FALSE;

    /**
     * 删除标志
     */
    private Boolean deleteFlag = Boolean.FALSE;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime = DateUtils.getCurrentDateTime();

    /**
     * 最后修改人
     */
    private String modifier;

    /**
     * 最后修改时间
     */
    private Date modifiedTime = DateUtils.getCurrentDateTime();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

//    public Integer getSex() {
//        return sex;
//    }
//
//    public void setSex(Integer sex) {
//        this.sex = sex;
//    }


    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", accountName='" + accountName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birth=" + birth +
                ", sex=" + sex +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", roleType=" + roleType +
                ", rank=" + rank +
                ", frozen=" + frozen +
                ", deleteFlag=" + deleteFlag +
                ", remark='" + remark + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", modifier='" + modifier + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
