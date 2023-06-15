package com.atguigu.syt.user.client.callback;

import com.atguigu.syt.model.user.Patient;
import com.atguigu.syt.user.client.PatientFeignClient;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -21:36
 * @Version: 1.0
 */
@Component
public class PatientFeignClientCallback implements PatientFeignClient {
    @Override
    public Patient getPatientInfo(Long patientId) {
        return null;
    }
}
