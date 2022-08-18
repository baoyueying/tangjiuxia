package com.dxh.service.serviceImpl;

import com.dxh.mapper.UserMapper;
import com.dxh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

}
