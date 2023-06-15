package com.atguigu.syt.hosp.controller.inner;

import com.atguigu.syt.hosp.service.HospitalSetService;
import com.atguigu.syt.vo.order.SignInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/15 -23:12
 * @Version: 1.0
 */
@RestController
@RequestMapping("/inner/hosp/hospset")
public class InnerHospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("getSignInfoVo/{hoscode}")
    public SignInfoVo getSignInfoVo(@PathVariable String hoscode) {
        return hospitalSetService.getSignInfoVoByHocode(hoscode);
    }

}
