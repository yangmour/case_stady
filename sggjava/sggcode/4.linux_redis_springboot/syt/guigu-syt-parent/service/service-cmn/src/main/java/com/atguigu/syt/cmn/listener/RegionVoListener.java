package com.atguigu.syt.cmn.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.atguigu.syt.cmn.mapper.RegionMapper;
import com.atguigu.syt.vo.cmn.RegionExcelVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/02 -14:13
 * @Version: 1.0
 */
@Slf4j
public class RegionVoListener implements ReadListener<RegionExcelVo> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 500;
    /**
     * 缓存的数据
     */
    private List<RegionExcelVo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    @Autowired
    private RegionMapper regionMapper;

    public RegionVoListener(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    @Override
    public void invoke(RegionExcelVo regionVo, AnalysisContext analysisContext) {
        log.info("RegionVoListener.invoke执行完毕,结果:{}", regionVo);
        cachedDataList.add(regionVo);
        if (cachedDataList.size() >= BATCH_COUNT) {
            regionMapper.batchInsert(cachedDataList);
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("RegionVoListener.doAfterAllAnalysed执行完毕,结果:{}", cachedDataList);
        regionMapper.batchInsert(cachedDataList);
    }
}
