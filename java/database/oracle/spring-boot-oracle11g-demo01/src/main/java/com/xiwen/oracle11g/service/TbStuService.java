package com.xiwen.oracle11g.service;

import com.xiwen.oracle11g.entity.TbStu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 希文
* @description 针对表【TB_STU】的数据库操作Service
* @createDate 2023-07-09 16:58:53
*/
public interface TbStuService extends IService<TbStu> {

    TbStu cs();
}
