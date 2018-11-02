package com.grateful.demo.content.service;

import com.grateful.demo.content.entity.Log;
import com.grateful.demo.content.entity.Role;
import com.grateful.demo.content.mapper.RoleMapper;
import com.grateful.demo.frameWork.common.OperateResultWithData;
import com.grateful.demo.frameWork.common.Search;
import com.grateful.demo.frameWork.utils.DateUtils;
import com.grateful.demo.frameWork.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * DESC:
 * USER: C.HE
 * DATE: 2018/10/21 9:02
 * VERSION: 0.0.1
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private LogService logService;

    /**
     * 根据联合索引查询唯一记录
     * @param roleType
     * @return
     */
    public Role findByRoleType(Integer roleType){
        return roleMapper.findByRoleType(roleType);
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Role findOne(String id){
        return roleMapper.findOne(id);
    }

    /**
     * 根据条件查询
     * @param search
     * @return
     */
    public List<Role> listByCondition(Search search){
        return roleMapper.listByCondition(search);
    }

    /**
     * 根据条件查询记录条数
     * @param search
     * @return
     */
    public Integer countByCondition(Search search){
        return roleMapper.countByCondition(search);
    }



    /**
     * 保存/更新一条记录
     */
    @Transactional
    public OperateResultWithData save(Role entity){
        //唯一性校验
        Role role = findByRoleType(entity.getRoleType());
        if (role != null) {//如果存在记录（两种可能：新增时存在记录，更新时存在记录）
            if (StringUtils.isEmpty(entity.getId()) || (!role.getId().equals(entity.getId()))) {
                return OperateResultWithData.operationFailure("已存在相同角色记录！");
            }
        }
        //插入
        if(StringUtils.isEmpty(entity.getId())){
            return roleService.insert(entity);
        }else{//更新
            return roleService.update(entity);
        }
    }

    /**
     * 插入
     * @param entity
     * @return
     */
    @Transactional
    public OperateResultWithData insert(Role entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("保存成功！");
        try{
            //插入数据
            entity.setId(IdGenerator.uuid());
            roleMapper.insert(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("保存role角色");
            logService.save(log);
        }catch (Exception e){
            e.printStackTrace();
            resultWithData = OperateResultWithData.operationFailure();
        }
        return resultWithData;
    }

    /**
     * 更新
     * @param entity
     * @return
     */
    @Transactional
    public OperateResultWithData update(Role entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("更新成功");
        try{
            //更新数据
            entity.setModifiedTime(DateUtils.getCurrentDateTime());
            roleMapper.update(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("更新role角色");
            logService.save(log);
        }catch (Exception e){
            e.printStackTrace();
            resultWithData = OperateResultWithData.operationFailure();
        }
        return resultWithData;
    }
}
