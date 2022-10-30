package com.xiwen.mapreduce.reducejoin2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TableDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, URISyntaxException {

        //7步
        //1
        Job job = Job.getInstance(new Configuration());

        //2
        job.setJarByClass(TableDriver.class);

        //3
        job.setMapperClass(TableMapper.class);

        //4
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        //5
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        //设置缓存文件
        job.addCacheFile(new URI("input/cacheinput/pd.txt"));
        // Map端Join的逻辑不需要Reduce阶段，设置reduceTask数量为0
        job.setNumReduceTasks(0);

        //6
        FileInputFormat.setInputPaths(job, new Path("input/reducejoininput"));
        FileOutputFormat.setOutputPath(job, new Path("output"));

        //7
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
