package com.atguigu.syt.cmn.client;

import com.atguigu.syt.cmn.client.impl.DictDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/05 -18:26
 * @Version: 1.0
 */
@FeignClient(value = "service-cmn", contextId = "dictFeignClient", fallback = DictDegradeFeignClient.class)
public interface DictFeignClient {

    @GetMapping(value = "/inner/cmn/dict/getName/{dictTypeId}/{value}")
    String getHostName(@PathVariable("dictTypeId") Long dictTypeId, @PathVariable("value") String value);
}
