package com.xtkj.dao;

import com.xtkj.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer tbUserid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer tbUserid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}