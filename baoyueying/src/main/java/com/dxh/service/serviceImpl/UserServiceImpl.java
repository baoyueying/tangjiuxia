package com.dxh.service.serviceImpl;


import com.dxh.domain.ResponseResult;
import com.dxh.domain.entity.User;
import com.dxh.enums.ResponseCodeEnums;
import com.dxh.mapper.UserMapper;
import com.dxh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseResult listUsers() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        return ResponseResult.okResult(users);
    }

    @Override
    public ResponseResult queryUser(int id) {
        User user = userMapper.selectById(id);
        return ResponseResult.okResult(user);
    }

    @Override
    public ResponseResult addUser(User user) {
        int insert = userMapper.insert(user);
        if (insert != 0){
            return ResponseResult.okResult();
        } else {
            return  ResponseResult.errorResult(ResponseCodeEnums.SERVER_ERROR.getCode(),ResponseCodeEnums.SERVER_ERROR.getMsg());
        }
    }


}
