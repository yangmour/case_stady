package com.xiwen.mapreduce.compress;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    /**
     * 由于每行单词都要走map方法如果每次都创建一个对象都会耗费内存就写在外面
     */
    private Text outK = new Text();
    private IntWritable outV = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        //转成String类型
        String line = value.toString();
        //以空格切割
        String[] words = line.split(" ");
        for (String word : words) {
            //设置outKey
            outK.set(word);
            //输出
            context.write(outK, outV);
        }

    }
}
