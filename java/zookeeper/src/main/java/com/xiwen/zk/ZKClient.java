package com.xiwen.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ZKClient {
    // 如果windows的hosts文件中没有配置解析域名要写ip
    // 注意：逗号前后不能有空格
    private String connectString = "hadoop102:2181,hadoop103:2181,hadoop:2181";
    private int sessionTimeout = 2 * 1000;
    private ZooKeeper zkClient;

    @Test
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }


}
