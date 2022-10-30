package com.xiwen.mapreduce.reducejoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TableDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        //7步
        //1
        Job job = Job.getInstance(new Configuration());

        //2
        job.setJarByClass(TableDriver.class);

        //3
        job.setMapperClass(TableMapper.class);
        job.setReducerClass(TableReduce.class);

        //4
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TableBean.class);

        //5
        job.setOutputKeyClass(TableBean.class);
        job.setOutputValueClass(NullWritable.class);

        //6
        FileInputFormat.setInputPaths(job, new Path("input/com.xiwen.mapreduce.reducejoin"));
        FileOutputFormat.setOutputPath(job, new Path("output"));

        //7
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
