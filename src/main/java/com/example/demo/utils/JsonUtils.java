package com.example.demo.utils;

import static com.alibaba.fastjson.JSON.toJSONString;

public class JsonUtils {
    private JsonUtils() {
        throw new IllegalAccessError("Utility class");
    }


    //toJSONString将对象转化为Json字符串
    public static String toJsonString(Object dto) throws IllegalAccessException {
        return toJSONString(dto);
    }
}
