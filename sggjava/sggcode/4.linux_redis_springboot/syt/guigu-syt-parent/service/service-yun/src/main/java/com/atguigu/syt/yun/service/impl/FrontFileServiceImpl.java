package com.atguigu.syt.yun.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.yun.service.FrontFileService;
import com.atguigu.syt.yun.utils.OssConstantProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
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
    private OssConstantProperties ossConstantProperties;

    @Override
    public Map<String, String> upload(MultipartFile file) {

        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = ossConstantProperties.getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ossConstantProperties.getKeyId();
        String accessKeySecret = ossConstantProperties.getKeySecret();
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ossConstantProperties.getBucketName();
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如：年/月/日/exampleobject.txt。
        String objectName = new DateTime().toString("yyyy/MM/dd")
                + UUID.randomUUID().toString().replaceAll("-", "")
                + file.getOriginalFilename();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);

            //返回图片路径
            // 设置签名URL过期时间，单位为毫秒。本示例以设置过期时间为1小时为例。
            Date expiration = new Date(new Date().getTime() + 3600 * 1000L);
            // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
            URL url = ossClient.generatePresignedUrl(bucketName, objectName, expiration);

            HashMap<String, String> map = new HashMap<>();
            map.put("previewUrl", url.toString()); //页面中授权预览图片
            map.put("url", objectName); //数据库存储
            return map;
        } catch (Exception oe) {
            log.error(ExceptionUtils.getStackTrace(oe));
            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
