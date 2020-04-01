package com.wsat.module.system.controller;




import com.wsat.module.system.model.UserInfo;
import com.wsat.module.system.model.enums.RoleEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 切片资料库_用户表 前端控制器
 * </p>
 *
 * @author dell
 * @since 2019-04-18
 */
@Api(value ="用户管理",tags="用户管理")
@RestController
@RequestMapping("/system/user")
public class UserInfoController  {


    @ApiOperation(value = "获取用户基础信息")
    @GetMapping("/getInfo")
    public UserInfo getInfo() {
        UserInfo userInfo = new UserInfo().setSex("0").setPhone("1550632114").setRole(RoleEnum.ROLE_USER).setUserNo(0L);
        return userInfo;
    }

}

