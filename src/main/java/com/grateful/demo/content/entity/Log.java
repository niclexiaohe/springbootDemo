package com.grateful.demo.content.entity;

import com.grateful.demo.frameWork.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * DESC: 操作日志
 * USER: C.HE
 * DATE: 2018/10/19 17:34
 * VERSION: 0.0.1
 */
public class Log implements Serializable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operateTime = DateUtils.getCurrentDateTime();

    /**
     * 操作描述
     */
    private String operateDesc;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
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
        return "Log{" +
                "id='" + id + '\'' +
                ", operator='" + operator + '\'' +
                ", operateTime=" + operateTime +
                ", operateDesc='" + operateDesc + '\'' +
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
