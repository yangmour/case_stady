package com.example.demo.demos.web.feign.config;

import com.example.demo.demos.web.config.JsonUtil;
import com.example.demo.demos.web.r.R;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Util;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * 前置请求学习，后置编码器解码器学习
 * https://blog.csdn.net/util123/article/details/133771035
 */
@Slf4j
public class FeignConfig implements RequestInterceptor {

    private final ThreadLocal<Object> threadLocal = new ThreadLocal<>();


    @Bean
    // 写法1
    public Decoder customDecoder(ObjectFactory<HttpMessageConverters> msgConverters,
                                 ObjectProvider<HttpMessageConverterCustomizer> customizers) {
    // 写法2
//    public Decoder customDecoder() {
        // 这里不管用
//        Object o = threadLocal.get();
        return (resp, type) -> {
            // 这里才行
            Object o = threadLocal.get();
            log.info("线程内请求前日志:{}", o);
            // 写法1
            Type orginalType = null;
            if(type instanceof ParameterizedType){
                // T是泛型如List<> Map<>，会被封装为ParameterizedTypeImpl
                orginalType = ParameterizedTypeImpl.make(R.class,new Type[]{type},null);
            }else {
                // T是Class类型
                orginalType = ParameterizedTypeImpl.make(R.class,new Type[]{type},null);
            }
            SpringDecoder springDecoder = new SpringDecoder(msgConverters, customizers);
            R<?> r = (R<?>) springDecoder.decode(resp,orginalType);
            if(r.getCode() != 200){
                throw new RuntimeException(r.getMsg());
            }
            return r.getData();
            // 写法2
//            String json = Util.toString(resp.body().asReader(Charset.defaultCharset()));
////            log.debug("feign调用返回对象：json={}", json);
//            ResolvableType resolvableType = ResolvableType.forType(type);
//            //如果是基本类型，那么获取class，在判断结果是否为null，如果是null，则直接返回
//            JavaType resolvableJavaType = this.getJavaType(resolvableType.getType());
//            JavaType javaType = this.getJavaType(R.class, resolvableJavaType);
//
////            log.debug("feign调用返回对象类型：javaType={}", javaType);
//            R<?> r = JsonUtil.toBean(json, javaType);
//            if (r.getCode() != 200) {
////                log.error("调用接口业务异常 url:{} code:{} msg:{}", response.request().url(), r.getCode(), r.getMsg());
//                throw new RuntimeException(r.getMsg());
//            }
//            return r.getData();
        };
    }

    @Bean
    public ErrorDecoder  customErrorDecoder() {
        return (method, resp) -> {
            // 这里才行
            Object o = threadLocal.get();
            log.info("线程内请求前日志:{}", o);
            // 获取原始的返回内容
            try {
                String json = Util.toString(resp.body().asReader(Charset.defaultCharset()));
//                log.error("fegin调用异常处理 请求{} 返回:{}", resp.request().toString(), json);
                R<?> r = JsonUtil.toBean(json, new ParameterizedTypeReference<R<?>>() {});
                return new RuntimeException(r.getMsg());
            } catch (IOException e) {
                return new RuntimeException(e);
//            }
            }
        };
    }

    /**
     * 请求前置操作例如：加密日志
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {

    }





}
