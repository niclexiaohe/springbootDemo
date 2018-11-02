package com.grateful.demo.content.mapper;

import com.grateful.demo.content.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * DESC: 用户mapper
 * USER: C.HE
 * DATE: 2018/10/20 21:27
 * VERSION: 0.0.1
 */
@Mapper
public interface UserMapper {

    /**
     * 根据联合索引获取唯一记录
     * @param accountName 账户名
     * @return
     */
    public User findByAccountName(String accountName);

    /**
     * 获取id记录
     * @param id
     * @return
     */
    public User findOne(String id);

    /**
     * 插入一条记录
     * @param user
     */
    public void insert(User user);

    /**
     * 更新一条记录
     * @param user
     */
    public void update(User user);

}
