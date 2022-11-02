package com.xiwen.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZKClient {
    // 如果windows的hosts文件中没有配置解析域名要写ip
    // 注意：逗号前后不能有空格
    private String connectString = "hadoop102:2181,hadoop103:2181,hadoop:2181";
    private int sessionTimeout = 2 * 1000;
    private ZooKeeper zkClient = null;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //第一个监听路径，第二个参数监听器设置为true使用默认的，上面创建客户端的监听器
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/", true);

                    for (String child : children) {
                        System.out.println(child);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    //创建字节点
    @Test
    public void create() throws Exception {

        // 参数 1：要创建的节点的路径； 参数 2：节点数据 ； 参数 3：节点权限 ；
        // 参数 4：节点的类型
        String nodeCreated = zkClient.create("/xiwen3", "sanguo2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(nodeCreated);
    }

    //获取子节点
    @Test
    public void getChildren() throws Exception {

        //第一个监听路径，第二个参数监听器设置为true使用默认的，上面创建客户端的监听器
        List<String> children = zkClient.getChildren("/", true);
//        for (String child : children) {
//            System.out.println(child);
//        }

        //延时阻塞
        Thread.sleep(Long.MAX_VALUE);

    }

    //判断znode是否存在
    @Test
    public void exist() throws InterruptedException, KeeperException {
        Stat stat = zkClient.exists("/xiwen", false);

        System.out.println(stat == null ? "not exist" : "exist");

    }

}
