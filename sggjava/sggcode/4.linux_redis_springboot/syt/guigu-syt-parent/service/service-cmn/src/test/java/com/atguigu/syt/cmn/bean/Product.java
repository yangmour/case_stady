package com.atguigu.syt.cmn.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/31 -19:10
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @ExcelProperty("id")
    private Integer id;

    @ColumnWidth(60)
    @ExcelProperty("名字")
    private String name;
    @ExcelProperty("工资")
    private Double price;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
