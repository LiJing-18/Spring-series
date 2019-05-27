package com.karat.cn.mapper;

import com.karat.cn.pojo.User;
import java.util.List;


public interface UserMapper {
    /**根据主键删除**/
    int deleteByPrimaryKey(String id);
    /**添加用户**/
    int insert(User record);
    /**查看所有用户**/
    List<User> selectByExample();
    /**根据Id查看用户信息**/
    User selectByPrimaryKey(String id);
    /**更新用户信息**/
    int updateByPrimaryKeySelective(User record);

}