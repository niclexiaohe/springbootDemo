package com.grateful.demo.content.service;

import com.grateful.demo.content.entity.Authority;
import com.grateful.demo.content.entity.Log;
import com.grateful.demo.content.entity.Module;
import com.grateful.demo.content.mapper.AuthorityMapper;
import com.grateful.demo.content.mapper.ModuleMapper;
import com.grateful.demo.frameWork.common.OperateResultWithData;
import com.grateful.demo.frameWork.utils.DateUtils;
import com.grateful.demo.frameWork.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * DESC: 角色权限service
 * USER: C.HE
 * DATE: 2018/10/21 9:06
 * VERSION: 0.0.1
 */
@Service
public class AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private LogService logService;

    /**
     * 根据联合索引查询唯一记录
     * @param moduleCode
     * @return
     */
    public Authority findByRoleTypeAndModuleCode(Integer roleType, String moduleCode){
        return authorityMapper.findByRoleTypeAndModuleCode(roleType, moduleCode);
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Authority findOne(String id){
        return authorityMapper.findOne(id);
    }

    /**
     * 根据角色类型获取所有权限菜单
     * @param roleType
     * @return
     */
    public List<Authority> listByRoleType(Integer roleType){
        return authorityMapper.listByRoleType(roleType);
    }

    /**
     * 保存/更新一条记录
     */
    @Transactional
    public OperateResultWithData save(Authority entity){
        //唯一性校验
        Authority authority = findByRoleTypeAndModuleCode(entity.getRoleType(), entity.getModuleCode());
        if (authority != null) {//如果存在记录（两种可能：新增时存在记录，更新时存在记录）
            if (StringUtils.isEmpty(entity.getId()) || (!authority.getId().equals(entity.getId()))) {
                return OperateResultWithData.operationFailure("已存在相同角色权限记录！");
            }
        }
        //插入
        if(StringUtils.isEmpty(entity.getId())){
            return authorityService.insert(entity);
        }else{//更新
            return authorityService.update(entity);
        }
    }

    /**
     * 插入
     * @param entity
     * @return
     */
    @Transactional
    public OperateResultWithData insert(Authority entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("保存成功！");
        try{
            //插入数据
            entity.setId(IdGenerator.uuid());
            authorityMapper.insert(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("保存authority角色权限");
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
    public OperateResultWithData update(Authority entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("更新成功");
        try{
            //更新数据
            entity.setModifiedTime(DateUtils.getCurrentDateTime());
            authorityMapper.update(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("更新authority角色权限");
            logService.save(log);
        }catch (Exception e){
            e.printStackTrace();
            resultWithData = OperateResultWithData.operationFailure();
        }
        return resultWithData;
    }
}
