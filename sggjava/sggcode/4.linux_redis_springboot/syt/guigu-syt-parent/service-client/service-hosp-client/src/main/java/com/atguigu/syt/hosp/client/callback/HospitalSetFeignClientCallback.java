package com.atguigu.syt.hosp.client.callback;

import com.atguigu.syt.hosp.client.HospitalSetFeignClient;
import com.atguigu.syt.vo.order.SignInfoVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -23:21
 * @Version: 1.0
 */
@Component
public class HospitalSetFeignClientCallback implements HospitalSetFeignClient {
    @Override
    public SignInfoVo getSignInfoVo(String hoscode) {
        return null;
    }
}
