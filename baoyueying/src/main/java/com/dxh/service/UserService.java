package com.dxh.service;

import com.dxh.domain.ResponseResult;
import com.dxh.domain.entity.User;
import com.dxh.mapper.UserMapper;

public interface UserService{
    ResponseResult listUsers();

    ResponseResult queryUser(int id);

    ResponseResult addUser(User user);
}
