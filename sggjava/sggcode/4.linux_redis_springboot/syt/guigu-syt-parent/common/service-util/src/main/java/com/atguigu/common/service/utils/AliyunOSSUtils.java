package com.atguigu.common.service.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -23:13
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
@Slf4j
public class AliyunOSSUtils {
    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;

    public void upload(MultipartFile file, String objectName) throws IOException {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
        InputStream inputStream = file.getInputStream();
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
        // 创建PutObject请求。
        PutObjectResult result = ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();

    }


    public URL getGeneratePresignedUrl(String objectName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
        // 设置签名URL过期时间，单位为毫秒。本示例以设置过期时间为1小时为例。
        Date expiration = new Date(new Date().getTime() + 3600 * 1000L);
        // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
        return ossClient.generatePresignedUrl(bucketName, objectName, expiration);
    }

    public void deleteFile(String objectName) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);

        try {
            // 删除文件。
            ossClient.deleteObject(bucketName, objectName);
        } catch (OSSException oe) {
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
            log.info("AliyunOSSUtils.deleteFile执行完毕,结果:{}", "出现异常!" + ExceptionUtils.getStackTrace(oe));
        } catch (ClientException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
            log.info("AliyunOSSUtils.deleteFile执行完毕,结果:{}", "客户端出现异常!" + ExceptionUtils.getStackTrace(ce));

        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

    }

}
