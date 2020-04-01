package com.wsat.core.dict.enums;



import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;



/**
 * @description: 通用字典枚举
 * @author: wsat
 * @create: 2019-07-04 11:56
 **/
public interface IDictEnum<T extends Serializable> {

    /**
     * 数据库中存储的值
     * @return
     */
    @JsonValue
    T getValue();


    /**
     * 从数据库保存的字典ID
     * @return
     */
    String getDictCode();

}