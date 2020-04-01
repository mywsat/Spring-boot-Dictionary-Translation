package com.wsat.core.dict;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@ConditionalOnBean(DictInitialization.class)
@Component
public class DictManger {

    public static Map<String, List<DictItem>> cache = new ConcurrentHashMap<>(128);
    private DictInitialization dictInitialization;

    public DictManger(DictInitialization dictInitialization) {
        this.dictInitialization = dictInitialization;
        reInitDict(true);
    }

    /**
     * 添加字典内容
     *
     * @param items
     */
    public static void pushDictItems(List<DictItem> items) {
        Map<String, List<DictItem>> dicts = items.stream().collect(Collectors.groupingBy(DictItem::getDictType));
        cache.putAll(dicts);
    }

    /**
     * 重新初始化字典
     *
     * @param isCleanCache
     */
    public void reInitDict(boolean isCleanCache) {
        if (isCleanCache) {
            DictManger.cache.clear();
        }
        pushDictItems(dictInitialization.init());
    }

    /**
     * 通过字典编码,字典值取字典翻译名称
     *
     * @param code
     * @param value
     */
    public static String getDictName(String code, String value) {
        if (code!=null&&cache.containsKey(code)) {
            Optional<DictItem> findDict = cache.get(code).stream().filter(dictItem -> dictItem.getValue().equals(value)).findFirst();
            if (findDict.isPresent()) {
                return findDict.get().getName();
            }
        }
        return "";
    }

    /**
     * 通过字典编码,字典值取字典翻译名称
     *
     * @param code
     * @param value
     */
    public static String getDictName(String code, Serializable value) {
        if(value==null){
            return null;
        }
        return DictManger.getDictName(code, value.toString());
    }



}

    
