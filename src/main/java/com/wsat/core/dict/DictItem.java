package com.wsat.core.dict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 字典项
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DictItem {
    /**
     * 字典类型编码
     */
    private String dictType;
    /**
     * 字段的value值
     */
    private String value;
    /**
     * 字段的翻译值
     */
    private String name;
}
