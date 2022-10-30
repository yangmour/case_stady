package com.xiwen.mapreduce.compress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        //7步

        //1.获取配置信息以及获取job对象
        Configuration conf = new Configuration();

        // 开启map端输出压缩
        conf.setBoolean("mapreduce.map.output.compress", true);

        // 设置map端输出压缩方式
        conf.setClass("mapreduce.map.output.compress.codec", BZip2Codec.class, CompressionCodec.class);


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

        //6.设置输入输出路径
        //FileInputFormat.setInputPaths(job, new Path("D:\\software\\IDE\\Git\\prodect\\case_study\\java\\hadoop\\MapReduceDemo\\input\\hello"));
        FileInputFormat.setInputPaths(job, new Path("input\\hello"));
        FileOutputFormat.setOutputPath(job, new Path("output"));

        // 设置reduce端输出压缩开启
        FileOutputFormat.setCompressOutput(job, true);

        // 设置压缩的方式
        FileOutputFormat.setOutputCompressorClass(job, BZip2Codec.class);
//	    FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
//	    FileOutputFormat.setOutputCompressorClass(job, DefaultCodec.class);


        //7.提交job任务
        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);


    }
}
