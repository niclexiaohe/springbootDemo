package com.grateful.demo.content.service;

import com.grateful.demo.content.entity.Log;
import com.grateful.demo.content.mapper.LogMapper;
import com.grateful.demo.content.mapper.UserMapper;
import com.grateful.demo.content.entity.User;
import com.grateful.demo.frameWork.common.OperateResultWithData;
import com.grateful.demo.frameWork.utils.DateUtils;
import com.grateful.demo.frameWork.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 用户Service
 */
@Service
//@Transactional//事务控制
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;


    /**
     * 根据联合索引获取唯一记录
     * @param accountName 账户名
     * @return
     */
    public User findByAccountName(String accountName){
        return userMapper.findByAccountName(accountName);
    }

    /**
     * 获取一条记录
     * @param id
     * @return
     */
    public User findOne(String id){
        return userMapper.findOne(id);
    }

    /**
     * 保存/更新一条记录
     */
    @Transactional
    public OperateResultWithData save(User entity){
        //唯一性校验
        User user = findByAccountName(entity.getAccountName());
        if (user != null) {//如果存在记录（两种可能：新增时存在记录，更新时存在记录）
            if (StringUtils.isEmpty(entity.getId()) || (!user.getId().equals(entity.getId()))) {
                return OperateResultWithData.operationFailure("已存在相同用户！");
            }
        }
        //插入
        if(StringUtils.isEmpty(entity.getId())){
            return userService.insert(entity);
        }else{//更新
            return userService.update(entity);
        }
    }

    /**
     * 插入
     * @param entity
     * @return
     */
    @Transactional
    public OperateResultWithData insert(User entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("保存成功！");
        try{
            //插入数据
            entity.setId(IdGenerator.uuid());
            userMapper.insert(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("保存user");
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
    public OperateResultWithData update(User entity){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess("更新成功");
        try{
            //更新数据
            entity.setModifiedTime(DateUtils.getCurrentDateTime());
            userMapper.update(entity);
            //写操作日志
            Log log = new Log();
            log.setId(IdGenerator.uuid());
            log.setOperator("操作人");
            log.setOperateTime(DateUtils.getCurrentDateTime());
            log.setOperateDesc("更新user");
            logService.save(log);
        }catch (Exception e){
            e.printStackTrace();
            resultWithData = OperateResultWithData.operationFailure();
        }
        return resultWithData;
    }
}
