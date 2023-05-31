package com.atguigu.syt.cmn.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.atguigu.syt.cmn.bean.Product;
import com.atguigu.syt.cmn.mapper.RegionMapper;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/31 -19:24
 * @Version: 1.0
 */
public class ProductListener implements ReadListener<Product> {
//public class ProductListener extends AnalysisEventListener<Product> {
    /**
     * 每隔3条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 500;

    /**
     * 缓存的数据
     */
    private List<Product> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private RegionMapper regionMapper;

    public ProductListener(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    public ProductListener() {
    }

//    @Override
//    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
//        System.out.println("标题:" + headMap);
//    }


    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println(headMap);
    }

    @Override
    public void invoke(Product data, AnalysisContext context) {
        System.out.println(data);
    }

    //    @Override
//    public void invoke(Product data, AnalysisContext context) {
//        System.out.println("每行数据" + data);
//        cachedDataList.add(data);
//        if (cachedDataList.size() >= BATCH_COUNT) {
////            regionMapper.bantchInser(cachedDataList);
//            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//        }
//    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //收尾工作
//            regionMapper.bantchInser(cachedDataList);
        System.out.println("结尾...");
    }
}
