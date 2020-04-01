package com.wsat.module.system.model.enums;

import com.wsat.core.dict.enums.IDictEnum;

/**
 * @author WSAT
 * @Description:
 * @date 2020/4/115:52
 */
public enum  RoleEnum implements IDictEnum<String> {

    ROLE_ADMIN("ADMIN")
    ,ROLE_USER("USER");
    RoleEnum(String value){
        this.value=value;
    }
    String value;
    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getDictCode() {
        return "ROLE";
    }
}
