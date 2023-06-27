package com.xiwen.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("t_order")
@Data
public class Order {
    //用mybatisplus的@TableId(type = IdType.ASSIGN_ID) 的分布式id也行
    // 在properties中配置shadingshere的雪花算法作为分布式id也行，必须配置mysql的自增主键id让配置文件中的雪花算法给覆盖才生效
    @TableId(type = IdType.ASSIGN_ID)
//    @TableId(type = IdType.AUTO)
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal amount;
}