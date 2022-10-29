package com.xiwen.mapreduce.writablecompable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, FlowBean, Text> {

    private Text outV = new Text();
    private FlowBean outK = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, FlowBean, Text>.Context context) throws IOException, InterruptedException {

        String line = value.toString();

        //13470253144	180	     180	360
        //13509468723	7335	110349	117684
        String[] words = line.split("\t");

        //取手机号和上下行流量
        String phone = words[0];

        String upFlow = words[1];
        String downFlow = words[2];

        outV.set(phone);
        outK.setUpFlow(Long.parseLong(upFlow));
        outK.setDownFlow(Long.parseLong(downFlow));
        outK.setSumFlow();
        context.write(outK, outV);

    }
}
