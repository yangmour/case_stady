package com.xiwen.mapreduce.reducejoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class TableMapper extends Mapper<LongWritable, Text, Text, TableBean> {

    private String tableName;

    private Text outK = new Text();
    private TableBean outV = new TableBean();


    @Override
    protected void setup(Mapper<LongWritable, Text, Text, TableBean>.Context context) throws IOException, InterruptedException {

        InputSplit inputSplit = context.getInputSplit();
        FileSplit fs = (FileSplit) inputSplit;

        tableName = fs.getPath().getName();

    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, TableBean>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");


        if (tableName.contains("order")) {  //订单表

            outK.set(split[1]);

            outV.setId(split[0]);
            outV.setPid(split[1]);
            outV.setAmount(Integer.parseInt(split[2]));
            outV.setpName("");
            outV.setFlag("order");

        } else {    //商品表

            outK.set(split[0]);

            outV.setId("");
            outV.setPid(split[0]);
            outV.setAmount(0);
            outV.setpName(split[1]);
            outV.setFlag("pd");
        }
        context.write(outK, outV);

    }
}
