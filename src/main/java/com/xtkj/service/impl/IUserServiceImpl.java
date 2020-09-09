package com.xtkj.service.impl;

import com.xtkj.dao.UserMapper;
import com.xtkj.pojo.User;
import com.xtkj.service.IUserService;


public class IUserServiceImpl implements IUserService {
    private UserMapper userMapper;

    public IUserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User query(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int add(User user) {
        int row = userMapper.insertSelective(user);
        return row;
    }

    @Override
    public int delete(int id) {
        int row = userMapper.deleteByPrimaryKey(id);
        return row;
    }

    @Override
    public int update(User user) {
        int row = userMapper.updateByPrimaryKeySelective(user);
        return row;
    }
}
