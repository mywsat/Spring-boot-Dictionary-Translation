/**
 * Copyright 2018-2020 stylefeng & fengshuonan (sn93@qq.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wsat.core.config;


import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wsat.core.dict.annotation.DictAnnotationIntrospector;
import com.wsat.core.dict.enums.DictEnumWebSerializer;
import com.wsat.core.dict.enums.IDictEnumConvertFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

/**
 * web 配置类
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:03:32
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    IDictEnumConvertFactory dictEnumConvertFactory;

    @Autowired(required = false)
    DictAnnotationIntrospector dictAnnotationIntrospector;

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
       converters.stream().filter(converter->converter instanceof MappingJackson2HttpMessageConverter).forEach(converter->{
           MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter)converter;
           jsonConverter.getObjectMapper().setAnnotationIntrospector(dictAnnotationIntrospector);
           DictEnumWebSerializer dictEnumSerializer = new DictEnumWebSerializer();
           SimpleModule simpleModule = new SimpleModule();
           simpleModule.addSerializer(dictEnumSerializer);
           jsonConverter.getObjectMapper().registerModule(simpleModule);
       });
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(dictEnumConvertFactory);
    }
}
