package com.atguigu.syt.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/16 -11:39
 * @Version: 1.0
 */
@SpringBootTest
public class WxConfigTest {

//    @Autowired
//    private WxPayConfig wxPayConfig;

    @Test
    public void test() {
        //System.out.println(wxPayConfig.getPrivateKeyPath());
        File file1 = new File("apiclient_key.pem");
        System.out.println(file1.getAbsolutePath());
        System.out.println("------------------------");
//        File file = new File("wxPayConfig.getPrivateKeyPath()");
//        System.out.println(file.getAbsolutePath());
    }

}

