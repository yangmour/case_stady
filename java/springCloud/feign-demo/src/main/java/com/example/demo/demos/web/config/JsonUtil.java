package com.example.demo.demos.web.config;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import cn.hutool.json.JSONUtil;
import com.example.demo.demos.web.e.JsonException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;

/**
 * 序列化教程
 * https://blog.csdn.net/qq_38397501/article/details/117755936
 */
@Slf4j
public class JsonUtil extends ObjectMapper {

    private static final JsonMapper JSON_MAPPER = new JsonMapper();
    private static final long serialVersionUID = -1L;

    /**
     * 自定义配置JsonMapper对象方便序列化和反序列化
     */
    private JsonUtil() {
        // 解决实体未包含字段反序列化时抛出异常
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 对于空的对象转json的时候不抛出错误
        JSON_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        // 允许属性名称没有引号
        JSON_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        // 允许单引号
        JSON_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        // 忽略在json字符串中存在,但是在java对象中不存在对应属性的情况
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 处理时间转换问题
        JSON_MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        ————————————————
//        版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
//        原文链接：https://blog.csdn.net/qq_38397501/article/details/117755936
//        JSON_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        //允许单引号
//        JSON_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        //允许出现特殊字符和转义符
//        JSON_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
//        JSON_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        JSON_MAPPER.enable(ALLOW_NUMERIC_LEADING_ZEROS);
//        // 设置时区 getTimeZone("GMT+8:00")
//        JSON_MAPPER.setTimeZone(TimeZone.getDefault());
//        JSON_MAPPER.registerModules(new JavaTimeModule());
    }

    /**
     * 将一个object转换为json
     */
    public static String objectToJson(Object obj) {
        String json = null;
        try {
            json = JSON_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 将json数据转换成Map
     */
    public static Map<String, Object> jsonToMap(String json) {
        Map<String, Object> map = null;
        try {
            map = JSON_MAPPER.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将json数据转换成list
     */
    public static <T> List<T> jsonToList(String json, Class<T> beanType) {
        List<T> list = null;
        try {
            JavaType javaType =
                    JSON_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
            list = JSON_MAPPER.readValue(json, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取json对象数据的属性
     */
    public static String findValue(String resData, String resPro) {
        String result = null;
        try {
            JsonNode node = JSON_MAPPER.readTree(resData);
            JsonNode resProNode = node.get(resPro);
            result = JsonUtil.objectToJson(resProNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将对象转成json格式
     */
    public static String jsonString(Object data) {
        if (null == data) {
            return null;
        }
        String json = null;
        try {
            json = JSON_MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 原实体类List转换为目标实体类List
     *
     * @param srcList 原来的List
     * @param clz     要转换的实体类class
     */
    public static <T> List<T> srcList2ObjList(List<?> srcList, Class<T> clz) {
        String s = jsonString(srcList);
        if (s == null) {
            return new ArrayList<>();
        }
        return jsonToList(s, clz);
    }

    /**
     * 将json转成特定的cls的对象
     */
    public static <T> T jsonToBean(String json, Class<T> cls) {
        T t = null;
        try {
            t = JSON_MAPPER.readValue(json, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 原实体类转换为目标实体类
     *
     * @param src 原来的实体类
     * @param clz 目标实体类
     */
    public static <T> T src2Obj(Object src, Class<T> clz) {
        String s = jsonString(src);
        if (s == null) {
            return null;
        }
        return jsonToBean(s, clz);
    }

    public static JsonMapper getJsonMapper() {
        return JSON_MAPPER;
    }

    /**
     * 实体转json字符串
     * @param obj
     * @return
     * @throws JsonException
     */
    public static String toJson(Object obj) throws JsonException {
        try {
            return JSON_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json 转换异常 json:{}", obj, e);
            throw new JsonException(String.format("json转换异常 Class:%s", obj.getClass()), e);
        }
    }

    /**
     * json字符串转实体
     * @param json
     * @param responseTypeReference
     * @return
     * @param <T>
     * @throws JsonException
     */
    public static <T> T toBean(String json, ParameterizedTypeReference<T> responseTypeReference) throws JsonException {
        Type type = responseTypeReference.getType();
        JavaType javaType = JsonUtil.getJavaType(type);
        try {
            return JSON_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            log.error("json 转换异常 type:{} json:{}", type, json, e);
            throw new JsonException(String.format("json转换异常 json:%s", json), e);
        }
    }

    /**
     * json字符串转实体
     * @param json
     * @param clazz
     * @return
     * @param <T>
     * @throws JsonException
     */
    public static <T> T toBean(String json, Class<T> clazz) throws JsonException {
        try {
            return JSON_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new JsonException(String.format("json转换异常 json:%s", json), e);
        }
    }

    /**
     * 转成List集合
     * @param json
     * @param clazz
     * @return
     * @param <T>
     * @throws JsonException
     */
    public static <T> List<T> toList(String json, Class<T> clazz) throws JsonException {
        try {
            return JSON_MAPPER.readValue(json, JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
        } catch (IOException e) {
            throw new JsonException(String.format("json转换异常 json:%s clazz:%s", json, clazz.getName()), e);
        }
    }

    /**
     * 转成节点
     * @param json
     * @return
     * @throws JsonException
     */
    public static JsonNode toNode(String json) throws JsonException {
        try {
            return JSON_MAPPER.readTree(json);
        } catch (IOException e) {
            throw new JsonException(String.format("json转换异常 json:%s", json), e);
        }
    }

    /**
     * 转成实体
     * @param json
     * @param javaType
     * @return
     * @param <T>
     * @throws JsonException
     */
    public static <T> T toBean(String json, JavaType javaType) throws JsonException {
        try {
            return JSON_MAPPER.readValue(json, javaType);
        } catch (IOException e) {
            throw new JsonException(String.format("json转换异常 json:%s javaType:%s", json, javaType.getTypeName()), e);
        }
    }

    /**
     * 获取java类型
     * @param type
     * @return
     */
    public static JavaType getJavaType(Type type) {
        TypeFactory typeFactory = JSON_MAPPER.getTypeFactory();
        return typeFactory.constructType(type);
    }

    /**
     * 解决 嵌套泛型类型 Map<String, List<Integer>>
     *  例如
     *         String json = "{\"key1\": [1, 2, 3], \"key2\": [4, 5]}";
     *         // 嵌套泛型类型 Map<String, List<Integer>>
     *         JavaType javaType = getJavaType(Map.class,
     *                 JSON_MAPPER.getTypeFactory().constructType(String.class),
     *                 getJavaType(List.class, JSON_MAPPER.getTypeFactory().constructType(Integer.class)));
     *         // 将 JSON 转换为 Map<String, List<Integer>>
     *         Map<String, List<Integer>> result = JSON_MAPPER.readValue(json, javaType);
     *         System.out.println(result); // 输出: {key1=[1, 2, 3], key2=[4, 5]}
     * @param collectionClass
     * @param parameterTypes
     * @return
     */
    public static JavaType getJavaType(Class<?> collectionClass, JavaType... parameterTypes) {
        TypeFactory typeFactory = JsonUtil.getJsonMapper().getTypeFactory();
        return typeFactory.constructParametricType(collectionClass, parameterTypes);

    }

    /**
     * 是否是json类型
     * @param str
     * @return
     */
    public static boolean isTypeJSON(String str) {
        return JSONUtil.isTypeJSON(str);
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"key1\": [1, 2, 3], \"key2\": [4, 5]}";
        // 嵌套泛型类型 Map<String, List<Integer>>
        JavaType javaType = getJavaType(Map.class,
                JSON_MAPPER.getTypeFactory().constructType(String.class),
                getJavaType(List.class, JSON_MAPPER.getTypeFactory().constructType(Integer.class)));
        // 将 JSON 转换为 Map<String, List<Integer>>
        Map<String, List<Integer>> result = JSON_MAPPER.readValue(json, javaType);
        System.out.println(result); // 输出: {key1=[1, 2, 3], key2=[4, 5]}
    }

}
