package com.wsat.module.system.service.impl;

import com.wsat.core.dict.DictItem;
import org.springframework.stereotype.Service;
import com.wsat.module.system.service.IDictService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictServiceImpl implements IDictService {

    @Override
    public List<DictItem> init() {
        List<DictItem> dicts = new ArrayList<>();
        dicts.add(new DictItem().setDictType("SEX").setName("女").setValue("0"));
        dicts.add(new DictItem().setDictType("SEX").setName("男").setValue("0"));
        dicts.add(new DictItem().setDictType("ROLE").setName("管理员").setValue("ADMIN"));
        dicts.add(new DictItem().setDictType("ROLE").setName("用户").setValue("USER"));
        return dicts;
    }
}


