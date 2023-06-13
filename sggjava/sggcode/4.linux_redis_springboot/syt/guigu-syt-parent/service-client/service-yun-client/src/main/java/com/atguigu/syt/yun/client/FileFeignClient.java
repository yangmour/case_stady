package com.atguigu.syt.yun.client;

import com.atguigu.syt.yun.client.callback.FileFeignClientCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/13 -16:04
 * @Version: 1.0
 */

@FeignClient(value = "service-yun",
        contextId = "fileFeignClient",
        fallback = FileFeignClientCallBack.class
        , path = "/inner/yun/file"
)
public interface FileFeignClient {

    @GetMapping("getPreviewUrl")
    String getPreviewUrl(@RequestParam("objectName") String ObjectName);
}
