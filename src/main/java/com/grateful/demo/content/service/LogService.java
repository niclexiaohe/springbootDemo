package com.grateful.demo.content.service;

import com.grateful.demo.content.entity.Log;
import com.grateful.demo.content.mapper.LogMapper;
import com.grateful.demo.frameWork.common.OperateResultWithData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DESC: 操作日志service
 * USER: C.HE
 * DATE: 2018/10/20 21:34
 * VERSION: 0.0.1
 */
@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 保存/更新一条记录
     */
    @Transactional
    public OperateResultWithData save(Log log){
        OperateResultWithData resultWithData = OperateResultWithData.operationSuccess();
        try{
            logMapper.insert(log);
        }catch (Exception e){
            resultWithData = OperateResultWithData.operationFailure();
        }
        return resultWithData;
    }
}
