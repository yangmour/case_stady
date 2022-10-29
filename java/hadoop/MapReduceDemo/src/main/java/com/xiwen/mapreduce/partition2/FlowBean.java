package com.xiwen.mapreduce.partition2;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//1.继承Writable接口
public class FlowBean implements Writable {

    private Long upFlow;
    private Long downFlow;
    private Long sumFlow;

    // 2.提供无参构造方法
    public FlowBean() {
    }

    // 3.提供三个参数的构造方法
    public Long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(Long upFlow) {
        this.upFlow = upFlow;
    }

    public Long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(Long downFlow) {
        this.downFlow = downFlow;
    }

    public Long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(Long sumFlow) {
        this.sumFlow = sumFlow;
    }

    public void setSumFlow() {
        this.sumFlow = upFlow + downFlow;
    }


    //4.实现序列号和反序列化方法,注意顺序一定要一致
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(sumFlow);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.upFlow = in.readLong();
        this.downFlow = in.readLong();
        this.sumFlow = in.readLong();

    }
    //重写toString方法


    @Override
    public String toString() {
        return upFlow + "\t" + downFlow +
                "\t" + sumFlow;
    }
}
