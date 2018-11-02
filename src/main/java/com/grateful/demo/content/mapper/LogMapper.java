package com.grateful.demo.content.mapper;

import com.grateful.demo.content.entity.Log;
import org.apache.ibatis.annotations.Mapper;

/**
 * DESC: 操作日志mapper
 * USER: C.HE
 * DATE: 2018/10/20 21:27
 * VERSION: 0.0.1
 */
@Mapper
public interface LogMapper {

    /**
     * 插入一条记录
     * @param log
     */
    public void insert(Log log);
}
