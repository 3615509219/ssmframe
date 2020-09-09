package com.xtkj.service;

import com.xtkj.pojo.User;


public interface IUserService {

    User query(int id);
    int add(User user);
    int delete(int id);
    int update(User user);
}
