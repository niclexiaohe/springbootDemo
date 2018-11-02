package com.grateful.demo.content.service;

import com.grateful.demo.content.entity.Log;
import com.grateful.demo.content.entity.Module;
import com.grateful.demo.content.mapper.ModuleMapper;
import com.grateful.demo.frameWork.common.OperateResultWithData;
import com.grateful.demo.frameWork.utils.DateUtils;
import com.grateful.demo.frameWork.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * DESC: 菜单模块service
 * USER: C.HE
 * DATE: 2018/10/21 9:06
 * VERSION: 0.0.1
 */
@Service
public class ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private LogService logService;

    /**
     * 根据联合索引查询唯一记录
     * @param moduleCode
     * @return
     */
    public Module findByModuleCode(String moduleCode){
        return moduleMapper.findByModuleCode(moduleCode);
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Module findOne(String id){
        return moduleMapper.findOne(id);
    }

    /**
     * 保存/更新一条记录
     */
    @Transactional
    public OperateResultWithData save(Module entity){
        //唯一性校验
        Module module = findByModuleCode(entity.getModuleCode());
        if (module != null) {//如果存在记录（两种可能：新增时存在记录，更新时存在记录）
            if (StringUtils.isEmpty(entity.getId()) || (!module.getId().equals(entity.getId()))) {
                return OperateResultWithData.operationFailure("已存在相同功能项记录！");
            }
        }
        //插入
        if(StringUtils.isEmpty(entity.getId())){
            return moduleService.insert(entity);
        }else{//更新
            return moduleService.update(entity);
        }
    }

    /**
     * 插入
     * @param entity
     * @return
     */
    @Transactional
    public OperateResultWithData insert(Module entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("保存成功！");
        try{
            //插入数据
            entity.setId(IdGenerator.uuid());
            moduleMapper.insert(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("保存module功能项");
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
    public OperateResultWithData update(Module entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("更新成功");
        try{
            //更新数据
            entity.setModifiedTime(DateUtils.getCurrentDateTime());
            moduleMapper.update(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("更新module功能项");
            logService.save(log);
        }catch (Exception e){
            e.printStackTrace();
            resultWithData = OperateResultWithData.operationFailure();
        }
        return resultWithData;
    }
}
