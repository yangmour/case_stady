package com.atguigu.syt.doingcron.schedule;

import com.atguigu.syt.enums.RedisImagesConstant;
import com.atguigu.common.service.utils.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/20 -19:33
 * @Version: 1.0
 */
@Component
@Slf4j
public class DeleteImagesTask {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private AliyunOSSUtils aliyunOSSUtils;

    // 定时删除oss中认证失败图片
//    @Scheduled(cron = "*/8 * * * * ?")
    @Scheduled(cron = "0 0 0 15,30 * ?")
    public void deleteAuthenticatedImagesTask() {
        // 差集  如 k1: a b c k2: b d e  结果: a c
        Set<String> imagesPath = redisTemplate.opsForSet().difference(RedisImagesConstant.OSS_IMAGES_ALL_SET, RedisImagesConstant.OSS_IMAGES_AUTH_SET);
        if (imagesPath != null) {
            for (String image : imagesPath) {
                aliyunOSSUtils.deleteFile(image);
                log.info("删除图片定时任务->DeleteImagesTask.deleteAuthenticatedImagesTask执行完毕,结果:{}", "删除了:" + image);
            }

            Boolean f1 = redisTemplate.delete(RedisImagesConstant.OSS_IMAGES_ALL_SET);
            if (Boolean.TRUE.equals(f1)) {
                log.info("DeleteImagesTask.deleteAuthenticatedImagesTask执行完毕,结果:{}", "RedisImagesConstant.OSS_IMAGES_ALL_SET删除成功！");
            }
            Boolean f2 = redisTemplate.delete(RedisImagesConstant.OSS_IMAGES_AUTH_SET);
            if (Boolean.TRUE.equals(f2)) {
                log.info("DeleteImagesTask.deleteAuthenticatedImagesTask执行完毕,结果:{}", "RedisImagesConstant.OSS_IMAGES_AUTH_SET删除成功！");
            }
            log.info("DeleteImagesTask.deleteAuthenticatedImagesTask执行完毕,结果:{}", "删除成功！");

        }
        log.info("DeleteImagesTask.deleteAuthenticatedImagesTask执行完毕,结果:{}", "删除图片定时任务结束！");
    }
}
