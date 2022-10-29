package com.xiwen.mapreduce.combinetextinputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        //7步

        //1.获取配置信息以及获取job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //2.关联Driver程序的jar
        job.setJarByClass(WordCountDriver.class);
        //3.关联mapper和 reduce的jar
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReduce.class);

        //4.设置mapper的输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //5.设置最终的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //默认切片类TextInputFormat 是默认的FileInputFormat实现类。按行读取每条记录。
        //当前修改的CombineTextInputFormat适合多个小文件切成一片
        job.setInputFormatClass(CombineTextInputFormat.class);

        //6.设置输入输出路径
        //FileInputFormat.setInputPaths(job, new Path("D:\\software\\IDE\\Git\\prodect\\case_study\\java\\hadoop\\MapReduceDemo\\input\\hello"));
        FileInputFormat.setInputPaths(job, new Path("input/CombineTextInputFormat"));
        FileOutputFormat.setOutputPath(job, new Path("output"));
        //7.提交job任务

        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);


    }
}
