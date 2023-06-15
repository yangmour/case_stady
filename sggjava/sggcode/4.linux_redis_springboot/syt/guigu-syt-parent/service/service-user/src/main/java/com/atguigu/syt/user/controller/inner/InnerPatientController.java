package com.atguigu.syt.user.controller.inner;

import com.atguigu.syt.model.user.Patient;
import com.atguigu.syt.user.service.PatientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -21:29
 * @Version: 1.0
 */
@Api(tags = "就诊人接口-供其他微服务远程调用")
@RestController
@RequestMapping("/inner/user/patient")
public class InnerPatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getPatientInfo/{patientId}")
    public Patient getPatientInfo(@PathVariable("patientId") Long patientId) {
        return patientService.getById(patientId);
    }

}
