package com.xiwen.mapreduce.writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text,Text,FlowBean> {

    private Text outK = new Text();
    private FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context) throws IOException, InterruptedException {

        String line = value.toString();

        //1	13736230513	192.196.100.1	www.atguigu.com	2481	24681	200
        //2	13846544121	192.196.100.2			264	0	200
        String[] words = line.split("\t");

        //取手机号和上下行流量
        String phone = words[1];
        //1	13736230513	192.196.100.1	www.atguigu.com	2481	24681	200
        //2	13846544121	192.196.100.2			264	0	200
        //取下标
        //7-3 = 4
        //6-3 = 3
        String upFlow = words[words.length - 3];
        String downFlow = words[words.length - 2];

        outK.set(phone);
        outV.setUpFlow(Long.parseLong(upFlow));
        outV.setDownFlow(Long.parseLong(downFlow));
        outV.setSumFlow();
        context.write(outK,outV);

    }
}
