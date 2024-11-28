package com.example.demo.demos.web.feign;

import com.example.demo.demos.web.bean.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "cs", url = "", path = "/", configuration = )

/**
 * feign
 */
@FeignClient(name = "demo", url = "localhost:83", path = "")
public interface DemoFeignClient {


    @PostMapping("/demo")
    User cs();


}