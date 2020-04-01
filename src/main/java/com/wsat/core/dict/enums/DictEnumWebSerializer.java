package com.wsat.core.dict.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wsat.core.dict.DictManger;

import java.io.IOException;

/**
 * @description:枚举的Json序列化，返回字典解析的中文名称 (HTTP显示)
 * @author: wsat
 * @create: 2019-07-05 14:06
 **/
public class DictEnumWebSerializer extends JsonSerializer<IDictEnum> {
    @Override
    public void serialize(IDictEnum value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        if(value==null){
            jgen.writeNull();

        }
        jgen.writeObject(value.getValue());
        jgen.writeFieldName(jgen.getOutputContext().getCurrentName()+"Name");
        jgen.writeString(getEnumDesc(value));
    }

    @Override
    public Class handledType() {
        return IDictEnum.class;
    }

    private  String getEnumDesc(IDictEnum dictEnum){
        //此处从缓存中读取字典的信息
        return DictManger.getDictName(dictEnum.getDictCode(),dictEnum.getValue());
    }
}
