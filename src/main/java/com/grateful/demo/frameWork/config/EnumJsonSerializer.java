package com.grateful.demo.frameWork.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.grateful.demo.frameWork.utils.EnumUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * DESC: 对枚举类型进行序列化时的自定义序列化操作。
 * 只要对枚举类属性进行序列化操作（如：javasonUtil.obj2json()或controller向前端ajax返回json值等情况），就会多
 * 返回一组值，名为：枚举变量名Remark，值为@Remark（“备注”）注解中的备注。
 * USER: C.HE
 * DATE: 2018/10/23 15:01
 * VERSION: 0.0.1
 */
public class EnumJsonSerializer extends JsonSerializer<Enum> {

    @Override
    public void serialize(Enum anEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //        generator.writeStartObject();
        //默认序列化自身的值，作为自身属性的值
        jsonGenerator.writeString(anEnum.name());
        //或 也可定义成：默认序列化自身的索引值，作为自身属性的值。
//        jsonGenerator.writeString(String.valueOf(anEnum.ordinal()));
        //新增属性：枚举类型+Remark
        jsonGenerator.writeFieldName(StringUtils.uncapitalize(anEnum.getClass().getSimpleName()) + "Remark");
        //新增属性值：属性值等于@Remark注解中的value
        jsonGenerator.writeString(EnumUtils.getEnumItemRemark(anEnum.getClass(), anEnum));
//        generator.writeEndObject();
    }
}
