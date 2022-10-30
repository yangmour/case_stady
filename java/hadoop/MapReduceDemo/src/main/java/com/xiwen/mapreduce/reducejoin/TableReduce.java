package com.xiwen.mapreduce.reducejoin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableReduce extends Reducer<Text, TableBean, TableBean, NullWritable> {
    private TableBean pdBean = new TableBean();


    @Override
    protected void reduce(Text key, Iterable<TableBean> values, Reducer<Text, TableBean, TableBean, NullWritable>.Context context) throws IOException, InterruptedException {

        List<TableBean> orders = new ArrayList<>();

        for (TableBean value : values) {

            //判断数据来自哪个表
            if ("pd".equals(value.getFlag())) {
                try {
                    BeanUtils.copyProperties(pdBean, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //创建一个临时TableBean对象接收value
                TableBean tempOrderBean = new TableBean();
                try {
                    BeanUtils.copyProperties(tempOrderBean, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //将临时TableBean对象添加到集合orderBeans
                orders.add(tempOrderBean);
            }
        }

        for (TableBean orderBean : orders) {

            orderBean.setpName(pdBean.getpName());
            context.write(orderBean, NullWritable.get());
        }

    }
}
