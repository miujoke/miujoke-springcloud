package com.miujoke.common.utils;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.TimeZone;

/**
 * @Author: miujoke
 * @DateTime: 2021/9/5 22:19
 * json转换工具类
 */
public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final PrettyPrinter PRETTY_PRINTER = new DefaultPrettyPrinter();

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 忽略json字符串中不识别的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 忽略无法转换的对象 “No serializer found for class com.xxx.xxx”
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 指定时区，默认 UTC，而不是 jvm 默认时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

    }

    public static ObjectMapper objectMapper() {
        return objectMapper;
    }

    // json格式字符串转bean
    public static <T> T jsonStr2Bean(String json, Class<T> cls) {
        if (StringUtils.isEmpty(json)) {
            throw new IllegalArgumentException("json串不能为空");
        }
        if (null == cls) {
            throw new IllegalArgumentException("cls不能为null");
        }
        try {
            return objectMapper.readValue(json, cls);
        } catch (IOException e) {
            logger.error("json解析错误", e);
            throw new RuntimeException("json解析出错", e);
        }
    }


}
