package com.xiwen.mapreduce.reducejoin2;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TableMapper extends Mapper<LongWritable, Text, Text, NullWritable> {


    private Text outK = new Text();
    private Map<String, String> pd = new HashMap<>();


    @Override
    protected void setup(Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException, InterruptedException {

        //获取缓存文件
        URI[] cacheFiles = context.getCacheFiles();
        //获取第一个文件
        Path path = new Path(cacheFiles[0]);

        //创建一个文件系统对象
        FileSystem fileSystem = FileSystem.get(context.getConfiguration());
        //打开数据流
        FSDataInputStream fsDataInputStream = fileSystem.open(path);
        //将流转为reader流，方便按行读取
        InputStreamReader inputStreamReader = new InputStreamReader(fsDataInputStream, "UTF-8");
        //装入缓存流提高读写速度
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        //按行读取
        String line;
        while (StringUtils.isNotEmpty(line = bufferedReader.readLine())) {
            //01	小米
            String[] split = line.split("\t");
            //key = 01,value = 小米
            pd.put(split[0], split[1]);
        }

        //关流
        IOUtils.closeStream(bufferedReader);


    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");


        String id = split[0];
        String pName = pd.get(split[1]);
        String amount = split[2];

        outK.set(id + "\t" + pName + "\t" + amount);

        context.write(outK, NullWritable.get());

    }
}
