package com.atguigu.syt.yun.service.impl;

import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.enums.RedisImagesConstant;
import com.atguigu.syt.yun.service.FrontFileService;
import com.atguigu.common.service.utils.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -23:18
 * @Version: 1.0
 */
@Service
@Slf4j
public class FrontFileServiceImpl implements FrontFileService {

    @Autowired
    private AliyunOSSUtils aliyunOSSUtils;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Map<String, String> upload(MultipartFile file) {


        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如：年/月/日/exampleobject.txt。
        String objectName = new DateTime().toString("yyyy/MM/dd") + UUID.randomUUID().toString().replaceAll("-", "") + file.getOriginalFilename();

        try {
            //上传图片
            aliyunOSSUtils.upload(file, objectName);

            //上传一张就存储到redis中后期定期删除图片使用
            redisTemplate.opsForSet().add(RedisImagesConstant.OSS_IMAGES_ALL_SET, objectName);
            redisTemplate.opsForSet().add(RedisImagesConstant.OSS_IMAGES_AUTH_SET, objectName);
            //返回图片路径
            URL generatePresignedUrl = aliyunOSSUtils.getGeneratePresignedUrl(objectName);

            //封装到map中
            HashMap<String, String> map = new HashMap<>();
            map.put("previewUrl", generatePresignedUrl.toString()); //页面中授权预览图片
            map.put("url", objectName); //数据库存储
            return map;
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
        }
    }

    @Override
    public String getPreviewUrl(String objectName) {
        URL url = aliyunOSSUtils.getGeneratePresignedUrl(objectName);
        return url.toString();
    }
}
