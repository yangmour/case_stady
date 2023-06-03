package com.atguigu.hospital.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class HttpRequestHelper {

    /**
     *
     * @param paramMap
     * @return
     */
    public static Map<String, Object> switchMap(Map<String, String[]> paramMap) {
        Map<String, Object> resultMap = new HashMap<>();
        for (Map.Entry<String, String[]> param : paramMap.entrySet()) {
            resultMap.put(param.getKey(), param.getValue()[0]);
        }
        return resultMap;
    }

    /**
     * 验签方法
     * @param parameterMap
     */
    public static void checkSign(Map<String, Object> parameterMap, String signKey){
        //校验签名时间
        String remoteTimestamp = (String)parameterMap.get("timestamp");
        if(StringUtils.isEmpty(remoteTimestamp)){
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }
        long currentTimestamp = getTimestamp();
        if (Math.abs(currentTimestamp - Long.parseLong(remoteTimestamp)) > 5000) {
            log.error("签名已过期，服务器当前时间:{}", currentTimestamp);
            throw new YyghException(ResultCodeEnum.SIGN_OVERDUE);
        }

        //校验签名
        String signRemote = (String)parameterMap.get("sign");

        String signLocal = getSign(parameterMap, signKey);
        if(StringUtils.isEmpty(signRemote)){
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        if(!signRemote.equals(signLocal)){
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }
    }

    /**
     * 请求数据获取签名
     * @param paramMap
     * @return
     */
    public static String getSign(Map<String, Object> paramMap, String signKey) {
        //去掉sign参数
        if(paramMap.containsKey("sign")) {
            paramMap.remove("sign");
        }

        //有序
        TreeMap<String, Object> sorted = new TreeMap<>(paramMap);
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, Object> param : sorted.entrySet()) {
            //获取键值对中的值
            str.append(param.getValue()).append("|");
        }
        //最后连接signKey
        str.append(signKey);
        log.info("加密前：" + str);
        String md5Str = MD5.encrypt(str.toString());//不可逆加密算法
        log.info("加密后：" + md5Str);
        return md5Str;
    }

    /**
     * 获取时间戳
     * @return
     */
    public static long getTimestamp() {
        return new Date().getTime();
    }

    /**
     * 封装同步请求
     * @param paramMap
     * @param url
     * @return
     */
    public static JSONObject sendRequest(Map<String, Object> paramMap, String url){
        String result = "";
        try {
            //封装post参数
            StringBuilder postdata = new StringBuilder();
            for (Map.Entry<String, Object> param : paramMap.entrySet()) {
                postdata.append(param.getKey()).append("=")
                        .append(URLEncoder.encode(param.getValue().toString(),"utf-8")).append("&");
            }
            log.info(String.format("--> 发送请求：post data %1s", postdata));
            byte[] reqData = postdata.toString().getBytes("utf-8");
            //发送请求得到响应
            //使用HttpUtil调用远程接口，地址为url，参数为reqData，方式为post，返回结果为respdata
            byte[] respdata = HttpUtil.doPost(url,reqData);
            result = new String(respdata);
            log.info(String.format("--> 应答结果：result data %1s", result));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return JSONObject.parseObject(result);
    }
}
