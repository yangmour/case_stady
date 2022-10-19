package com.xiwen.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author 希文
 * <p>
 * 客户端代码通用套路
 * 1.获取客户端对象
 * 2.执行相关代码
 * 3.关闭资源
 * <p>
 * HDFS Zookeeper
 */
public class HdfsClient {

    private FileSystem fs;


    /**
     * 运行之前执行
     *
     * @throws Exception
     */
    @Before
    public void init() throws Exception {

        //连接namenode集群地址
        URI uri = new URI("hdfs://hadoop102:8020");
        //创建一个配置文件
        Configuration conf = new Configuration();
        //优先级最高
        //conf.set("dfs.replication","2");
        //指定集群用户
        String user = "study";

        fs = FileSystem.get(uri, conf, user);

    }

    /**
     * 运行后执行
     *
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

    /**
     * 上传文件
     * 参数优先级排序：（1）客户端代码中设置的值 >（2）ClassPath下的用户自定义配置文件 >（3）然后是服务器的自定义配置（xxx-site.xml） >（4）服务器的默认配置（xxx-default.xml）
     *
     * @throws IOException
     */
    @Test
    public void testCopyFormLocalFile() throws IOException {
        fs.copyFromLocalFile(false, true, new Path("C:\\Users\\xiwen\\Desktop\\hadoop\\hadoop3.1.3\\笔记（word版本）.zip"), new Path("/ApiOperation"));

    }


    /**
     * 下载文件
     *
     * @throws IOException
     */
    @Test
    public void testCopyToLocalFile() throws IOException {
        fs.copyToLocalFile(false, new Path("/ApiOperation"), new Path("./"), true);
    }

    /**
     * 文件更名和移动
     *
     * @throws IOException
     */
    @Test
    public void testRename() throws IOException {
        fs.rename(new Path("/ApiOperation"), new Path("/ApiOperationRename"));
    }

    /**
     * 删除文件和目录
     *
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
//        fs.delete(new Path("/ApiOperation"),true);
    }

    /**
     * 查看文件名称、权限、长度、块信息
     */
    @Test
    public void testListFiles() throws IOException {
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        System.out.println("permission" + "\t" + "owner" + "\t" + "group" + "\t" + "size" + "\t" + "modificationTime" + "\t" + "replication" + "\t" + "blockSize" + "\t" + "name");
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();
            FsPermission permission = fileStatus.getPermission();
            String owner = fileStatus.getOwner();
            String group = fileStatus.getGroup();
            long size = fileStatus.getLen();
            long modificationTime = fileStatus.getModificationTime();
            short replication = fileStatus.getReplication();
            long blockSize = fileStatus.getBlockSize();
            String name = fileStatus.getPath().getName();

            System.out.println(permission + "\t" + owner + "\t" + group + "\t" + size + "\t" + modificationTime + "\t" + replication + "\t" + blockSize + "\t" + name);
            //获取块信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
    }

    /**
     * 文件和文件夹判断
     */
    @Test
    public void testListStart() throws IOException {
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));


        for (FileStatus fileStatus : fileStatuses) {
            //如果是文件
            if (fileStatus.isFile()) {
                System.out.println("文件:" + fileStatus.getPath().getName());
            } else {
                System.out.println("目录:" + fileStatus.getPath().getName());

            }

        }

//        Stream<FileStatus> stream = Arrays.stream(fileStatuses);
//        stream.forEach(fileStatus -> {
//            //如果是文件
//            if (fileStatus.isFile()) {
//                System.out.println("文件:" + fileStatus.getPath().getName());
//            } else {
//                System.out.println("目录:" + fileStatus.getPath().getName());
//
//            }
//        });


    }
}
