package com.xiwen.es;

import com.xiwen.es.bean.Product;
import com.xiwen.es.dao.ElasticsearchDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ElasticsearchSpringDataEsApplicationTests {

    @Autowired
    private ElasticsearchDao elasticsearchDao;

    @Test
    void contextLoads() {
        for (int i = 0; i < 6; i++) {
            Product cs = elasticsearchDao.save(new Product(i+1, "cs" + i, 1000, 5000.1));
        }

    }

    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("cs1");
        list.add("cs2");
        List<Product> byPriceBetweenOrProductNameIn = elasticsearchDao.findByPriceBetweenOrProductNameIn(1000D, 2000D, list);
        System.out.println(byPriceBetweenOrProductNameIn);
    }
}
