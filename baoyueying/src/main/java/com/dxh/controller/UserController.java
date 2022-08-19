package com.dxh.controller;

import com.dxh.domain.ResponseResult;
import com.dxh.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseResult queryUser(@RequestParam int id){
        return userService.queryUser(id);
    }

    @Operation(summary = "测试",
            description = "query")
    @GetMapping(value = "/print")
    public String print(){
        return "asd";
    }
}
