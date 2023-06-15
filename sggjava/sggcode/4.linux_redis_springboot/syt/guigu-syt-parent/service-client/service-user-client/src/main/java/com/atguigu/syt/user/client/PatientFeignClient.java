package com.atguigu.syt.user.client;

import com.atguigu.syt.model.user.Patient;
import com.atguigu.syt.user.client.callback.PatientFeignClientCallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -21:34
 * @Version: 1.0
 */
@FeignClient(value = "service-user", contextId = "patientFeignClient", path = "/inner/user/patient", fallback = PatientFeignClientCallback.class)
public interface PatientFeignClient {
    @GetMapping("/getPatientInfo/{patientId}")
    Patient getPatientInfo(@PathVariable("patientId") Long patientId);
}
