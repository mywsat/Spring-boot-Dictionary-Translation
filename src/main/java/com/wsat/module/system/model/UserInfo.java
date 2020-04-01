package com.wsat.module.system.model;


import com.wsat.core.dict.annotation.Dict;

import com.wsat.module.system.model.enums.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="com-fidt-pims-module-system-model-UserInfo")
@Data
@Accessors(chain = true)
public class UserInfo{
    /**
     * 用户编码
     */
    @ApiModelProperty(value="用户编码")
    private Long userNo;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 性别（0女 1男）字典
     */
    @ApiModelProperty(value="性别（0女 1男）字典")
    @Dict("SEX")
    private String sex;


    /**
     * 角色
     */
    @ApiModelProperty(value="角色")
    private RoleEnum role;

}