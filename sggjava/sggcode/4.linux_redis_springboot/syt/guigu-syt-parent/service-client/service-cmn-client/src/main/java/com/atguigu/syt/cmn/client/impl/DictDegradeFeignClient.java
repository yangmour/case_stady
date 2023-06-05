package com.atguigu.syt.cmn.client.impl;

import com.atguigu.syt.cmn.client.DictFeignClient;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/05 -19:49
 * @Version: 1.0
 */
@Component
public class DictDegradeFeignClient implements DictFeignClient {

    @Override
    public String getHostName(Long dictTypeId, String value) {
        return "数据获取失败";
    }
}