package com.xiwen.zkcase1;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

public class DistributeServer {

    private String connectString = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zk = null;
    private String parentNode = "/servers";

    // 创建zk客户端
    public void getConnection() throws IOException {

        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });

    }

    //注册服务器
    public void registServer(String hostname) throws InterruptedException, KeeperException {

        String create = zk.create(parentNode + "/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        System.out.println(hostname + "is online " + create);
    }

    //业务功能
    public void business(String hostname) throws Exception {

        System.out.println(hostname + "is working ...");
        Thread.sleep(Long.MAX_VALUE);

    }

    public static void main(String[] args) throws Exception {

        //1.获取zk连接
        DistributeServer server = new DistributeServer();
        server.getConnection();

        // 2.列用zk连接注册服务信息
        server.registServer(args[0]);
        // 3.启动业务功能
        server.business(args[0]);


    }


}
