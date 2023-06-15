package com.atguigu.syt.hosp.client;

import com.atguigu.syt.hosp.client.callback.HospitalSetFeignClientCallback;
import com.atguigu.syt.vo.order.SignInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -23:20
 * @Version: 1.0
 */
@FeignClient(value = "service-hosp",contextId = "hospitalSetFeignClient",path = "/inner/hosp/hospset",fallback = HospitalSetFeignClientCallback.class)
public interface HospitalSetFeignClient {
    @GetMapping("getSignInfoVo/{hoscode}")
    SignInfoVo getSignInfoVo(@PathVariable String hoscode);
}
