package com.grateful.demo.content.mapper;

import com.grateful.demo.content.entity.Authority;
import com.grateful.demo.content.entity.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DESC: 角色权限mapper
 * USER: C.HE
 * DATE: 2018/10/21 10:38
 * VERSION: 0.0.1
 */
@Mapper
public interface AuthorityMapper {

    /**
     * 根据联合索引查询一条记录
     * @param roleType
     * @param moduleCode
     * @return
     */
    public Authority findByRoleTypeAndModuleCode(Integer roleType, String moduleCode);

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Authority findOne(String id);

    /**
     * 根据角色类型获取所有权限菜单
     * @param roleType
     * @return
     */
    public List<Authority> listByRoleType(Integer roleType);

    /**
     * 插入一条记录
     * @param authority
     */
    public void insert(Authority authority);

    /**
     * 更新一条记录
     * @param authority
     */
    public void update(Authority authority);

}
