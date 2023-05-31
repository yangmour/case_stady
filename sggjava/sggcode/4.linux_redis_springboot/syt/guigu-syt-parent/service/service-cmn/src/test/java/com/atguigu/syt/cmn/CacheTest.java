package com.atguigu.syt.cmn;

import com.atguigu.syt.cmn.service.RegionService;
import com.atguigu.syt.model.cmn.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/31 -18:56
 * @Version: 1.0
 */
@SpringBootTest
public class CacheTest {

    @Autowired
    private RegionService regionService;

    @Test
    public void test1() {
        Region r = new Region();
        r.setName("cacheTest");
        Region region = regionService.saveRegionWithCacheManager(r);
        System.out.println(region);
    }

    @Test
    public void test2() {
        regionService.deleteRegionWithCacheManager(3712L);
    }


}
