package com.xiwen.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

/**
 * @author 希文
 *
 * 客户端代码通用套路
 * 1.获取客户端对象
 * 2.执行相关代码
 * 3.关闭资源
 *
 * HDFS Zookeeper
 *
 */
public class HdfsClient {

    private FileSystem fs;


    /**
     * 运行之前执行
     * @throws Exception
     */
    @Before
    public void init() throws Exception {

        //连接namenode集群地址
        URI uri = new URI("hdfs://hadoop102:8020");
        //创建一个配置文件
        Configuration conf = new Configuration();
        //指定集群用户
        String user = "study";

        fs = FileSystem.get(uri, conf, user);

    }

    /**
     * 运行后执行
     * @throws IOException
     */
    @After
    public void close() throws IOException {
        fs.close();
    }

    @Test
    public void mkdirTest() throws Exception {
        fs.mkdirs(new Path("/ApiOperation"));

    }

}
