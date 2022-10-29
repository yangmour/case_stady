package com.xiwen.mapreduce.partition2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Job job = Job.getInstance(new Configuration());

        job.setJarByClass(FlowDriver.class);

        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReduce.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        //设置自定义分区
        job.setPartitionerClass(FlowPartitioner.class);
        /**
         * 设置分区数。
         *  1)将分区数应该与自定义分区数相同（就是自定义了几个分区reduce就写几）
         *  2)如果小于分区数会报错
         *  3)如果大于分区数多出来的分区就是一个空文件
         *  4)如果设置为0就是默认一个分区
         */
        job.setNumReduceTasks(5);

        args = new String[]{"input/phone_data", "output"};
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }
}