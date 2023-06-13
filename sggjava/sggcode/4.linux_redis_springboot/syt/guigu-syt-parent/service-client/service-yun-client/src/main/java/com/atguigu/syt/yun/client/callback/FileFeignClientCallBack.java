package com.atguigu.syt.yun.client.callback;

import com.atguigu.syt.yun.client.FileFeignClient;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/13 -16:06
 * @Version: 1.0
 */
@Component
public class FileFeignClientCallBack  implements FileFeignClient {
    @Override
    public String getPreviewUrl(String objectName) {
        return "获取图片失败";
    }
}