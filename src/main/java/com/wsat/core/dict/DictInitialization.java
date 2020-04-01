package com.wsat.core.dict;

import java.util.List;

/**
 * 字典初始化接口, 业务实现该接口 将系统字典导入
 */
public interface DictInitialization {

    /**
     * 获取字典翻译后的值
     * @return
     */
    List<DictItem> init();
}
