package com.dxh.controller;

import com.dxh.domain.ResponseResult;
import com.dxh.domain.entity.User;
import com.dxh.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController//@RestController=@Controller+@ResponseBody
@RequestMapping("/user")
@Tag(name = "UserController", description = "用户管理")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping(value = "/list")    //@GetMapping=@RequestMapping(method = RequestMethod.GET)
    @Operation(summary = "获取所有用户列表",description = "list")
    public ResponseResult listUsers() {
        return userService.listUsers();
    }


    @Operation(summary = "根据用户ID查询用户",
            description = "query",
            parameters = @Parameter(name = "id",description = "用户ID"))
    @GetMapping(value = "/query")
    public ResponseResult queryUser(@RequestParam(value = "id", required = true) int id ){
        return userService.queryUser(id);
    }


    @Operation(summary = "新增用户",
            description = "add",
            parameters = @Parameter(name = "User",description = "user"))
    @PostMapping (value = "/addUser")
    public ResponseResult toUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
