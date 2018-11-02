package com.grateful.demo.content.mapper;

import com.grateful.demo.content.entity.Role;
import com.grateful.demo.frameWork.common.Search;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DESC: 角色mapper
 * USER: C.HE
 * DATE: 2018/10/21 9:00
 * VERSION: 0.0.1
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据联合索引查询一条记录
     * @param roleType
     * @return
     */
    public Role findByRoleType(Integer roleType);

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Role findOne(String id);

    /**
     * 插入一条记录
     * @param role
     */
    public void insert(Role role);

    /**
     * 更新一条记录
     * @param role
     */
    public void update(Role role);

    /**
     * 根据条件查询
     * @return
     */
    public List<Role> listByCondition(Search search);

    /**
     * 根据条件查询记录条数
     * @return
     */
    public Integer countByCondition(Search search);
}
