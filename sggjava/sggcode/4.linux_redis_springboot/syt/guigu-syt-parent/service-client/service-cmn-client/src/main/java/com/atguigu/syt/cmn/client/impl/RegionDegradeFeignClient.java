package com.atguigu.syt.cmn.client.impl;

import com.atguigu.syt.cmn.client.RegionFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/05 -19:50
 * @Version: 1.0
 */
@Component
public class RegionDegradeFeignClient implements FallbackFactory<RegionFeignClient> {
    @Override
    public RegionFeignClient create(Throwable cause) {
        return code -> {
//            log.info("RegionDegradeFeignClient.create执行完毕,结果:{}",code);
            return "数据获取失败!";
        };
    }
}

//public class RegionDegradeFeignClient implements RegionFeignClient{
//
//    @Override
//    public String getRegionName(String code) {
//        return "数据获取失败!";
//    }
//}