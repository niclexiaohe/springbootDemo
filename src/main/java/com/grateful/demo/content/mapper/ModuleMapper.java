package com.grateful.demo.content.mapper;

import com.grateful.demo.content.entity.Module;
import org.apache.ibatis.annotations.Mapper;

/**
 * DESC: 菜单模块mapper
 * USER: C.HE
 * DATE: 2018/10/21 10:38
 * VERSION: 0.0.1
 */
@Mapper
public interface ModuleMapper {

    /**
     * 根据联合索引查询一条记录
     * @param moduleCode
     * @return
     */
    public Module findByModuleCode(String moduleCode);

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Module findOne(String id);

    /**
     * 插入一条记录
     * @param module
     */
    public void insert(Module module);

    /**
     * 更新一条记录
     * @param module
     */
    public void update(Module module);

}
