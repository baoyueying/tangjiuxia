package com.dxh.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    //指定主键ID 并设置id类型为自增
    @TableId(type = IdType.AUTO)
    private long id;

    private String userName;

    private String password;

    private String email;

    private String phoneNumber;

    //创建时间,插入数据时操作
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //更新时间，插入和更新是操作
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer deleted;
}
