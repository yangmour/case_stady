package com.atguigu.syt.cmn.client;

import com.atguigu.syt.cmn.client.impl.RegionDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/05 -18:28
 * @Version: 1.0
 */
@FeignClient(value = "service-cmn", contextId = "regionFeignClient", fallbackFactory = RegionDegradeFeignClient.class)
public interface RegionFeignClient {
    @GetMapping(value = "/inner/cmn/region/getName/{code}")
    String getRegionName(@PathVariable String code);
}
