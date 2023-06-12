package com.atguigu.syt.yun.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -23:17
 * @Version: 1.0
 */
public interface FrontFileService {
    Map<String, String> upload(MultipartFile file);
}
