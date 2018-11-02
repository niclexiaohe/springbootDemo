package com.grateful.demo.content.entity;

import com.grateful.demo.frameWork.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * DESC: 角色权限实体
 * USER: C.HE
 * DATE: 2018/10/21 11:15
 * VERSION: 0.0.1
 */
public class Authority implements Serializable {

    /**
     * 主键id
     */
    private String id;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 功能项代码
     */
    private String moduleCode;

    /**
     * 功能项名称
     */
    private String moduleName;

    /**
     * 功能项访问服务地址
     */
    private String moduleUrl;

    /**
     * 功能项图标地址
     */
    private String moduleImgUrl;

    /**
     * 父功能项代码
     */
    private String moduleParentCode = "0";

    /**
     * 父功能项排序
     */
    private Integer moduleParentRank = 0;

    /**
     * 子功能项排序
     */
    private Integer moduleChildRank = 0;


    /**
     * 排序
     */
    private Integer rank = 0;

    /**
     * 冻结标志 true-冻结  false-未冻结
     */
    private Boolean frozen = Boolean.FALSE;

    /**
     * 删除标志 true-删除  false-未删除
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

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getModuleImgUrl() {
        return moduleImgUrl;
    }

    public void setModuleImgUrl(String moduleImgUrl) {
        this.moduleImgUrl = moduleImgUrl;
    }

    public String getModuleParentCode() {
        return moduleParentCode;
    }

    public void setModuleParentCode(String moduleParentCode) {
        this.moduleParentCode = moduleParentCode;
    }

    public Integer getModuleParentRank() {
        return moduleParentRank;
    }

    public void setModuleParentRank(Integer moduleParentRank) {
        this.moduleParentRank = moduleParentRank;
    }

    public Integer getModuleChildRank() {
        return moduleChildRank;
    }

    public void setModuleChildRank(Integer moduleChildRank) {
        this.moduleChildRank = moduleChildRank;
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
        return "Authority{" +
                "id='" + id + '\'' +
                ", roleType=" + roleType +
                ", roleName='" + roleName + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", moduleUrl='" + moduleUrl + '\'' +
                ", moduleImgUrl='" + moduleImgUrl + '\'' +
                ", moduleParentCode='" + moduleParentCode + '\'' +
                ", moduleParentRank=" + moduleParentRank +
                ", moduleChildRank=" + moduleChildRank +
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
