package com.xiwen.mapreduce.partition2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlowPartitioner extends Partitioner<Text, FlowBean> {


    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {

        String phone = text.toString();
        String substring = phone.substring(0, 3);

        int setPartition;

        if ("136".equals(substring)) {
            setPartition = 0;
        } else if ("137".equals(substring)) {
            setPartition = 1;
        } else if ("138".equals(substring)) {
            setPartition = 2;
        } else if ("139".equals(substring)) {
            setPartition = 3;
        } else {
            setPartition = 4;
        }

        return setPartition;
    }
}
