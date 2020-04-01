package com.wsat.core.dict.enums;

import cn.hutool.core.util.StrUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * 用户前端直接接收枚举
 */
@Component
public class IDictEnumConvertFactory implements ConverterFactory<String, IDictEnum> {
    @Override
    public <T extends IDictEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToIEum<>(targetType);
    }

    @SuppressWarnings("all")
    private static class StringToIEum<T extends IDictEnum> implements Converter<String, T> {
        private Class<T> targerType;

        public StringToIEum(Class<T> targerType) {
            this.targerType = targerType;
        }
        @Override
        public T convert(String source) {
            if (StrUtil.isEmpty(source)) {
                return null;
            }
            return (T) IDictEnumConvertFactory.getIEnum(this.targerType, source);
        }
    }

    public static <T extends IDictEnum> Object getIEnum(Class<T> targerType, String source) {
        for (T enumObj : targerType.getEnumConstants()) {
            if (source.equals(String.valueOf(enumObj.getValue()))) {
                return enumObj;
            }
        }
        return null;
    }
}
