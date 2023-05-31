package com.atguigu.syt.cmn.test;

import com.alibaba.excel.EasyExcel;
import com.atguigu.syt.cmn.bean.Product;
import com.atguigu.syt.cmn.listener.ProductListener;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/31 -19:12
 * @Version: 1.0
 */
@SpringBootTest
public class EasyExcelTest {


    //最简单的写
    @Test
    public void testWrite() {
//        File file = new File("./");
//        System.out.println(file.getAbsolutePath());

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "张三", 10000D, "测试忽略的"));
        list.add(new Product(2, "李四", 10002D, "测试忽略的"));
        list.add(new Product(3, "王五", 10003D, "测试忽略的"));
        EasyExcel.write("./cs.xlsx", Product.class)
                .sheet("第一个模板")
                .doWrite(list);
    }

    //最简单的读
    @Test
    public void testRead() {
        EasyExcel.read("./cs.xlsx", Product.class, new ProductListener())
                .sheet("第一个模板").doRead();
    }

}
