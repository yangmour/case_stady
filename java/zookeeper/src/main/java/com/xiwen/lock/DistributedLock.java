package com.xiwen.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DistributedLock {

    private final String connectString = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private final int sessionTimeout = 2000;
    private ZooKeeper zk;

    private String rootNode = "locks";
    private String seq = "seq-";


    //zookeeper连接
    private CountDownLatch connectLath = new CountDownLatch(1);

    //zk锁
    private CountDownLatch waitLath = new CountDownLatch(1);
    private String waitNode;
    private String subNode;


    //和zk服务器建立连接
    public DistributedLock() throws Exception {
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                // connectLatch 如果连接上zk 可以释放
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    connectLath.countDown();
                }
                // wait latch 需要资源
                if (watchedEvent.getType() == Event.EventType.NodeDeleted && watchedEvent.getPath().equals(waitNode)) {
                    waitLath.countDown();
                }
            }
        });

        //等待连接建立
        connectLath.await();

        //获取根节点状态
        Stat stat = zk.exists("/" + rootNode, false);

        //如果根节点不存在就创建根节点
        if (stat == null) {
            System.out.println("根节点不存在");
            zk.create("/" + rootNode, rootNode.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        }

    }

    //加锁
    public void zkLock() throws Exception {

        //创建临时节点
        subNode = zk.create("/" + rootNode + "/" + seq, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        // wait 一小会, 让结果更清晰一些
        Thread.sleep(10);

        //判断创建的节点是否是最小的序号节点，如果是获取到锁；
        // 如果不是，监听他序号的前一个节点
        List<String> children = zk.getChildren("/" + rootNode, false);

        //如果只有一个节点直接加锁
        if (children.size() == 1) {
            return;
        } else {
            //排序
            Collections.sort(children);

            //获取当前节点名称
            String thisNode = subNode.substring(("/" + rootNode + "/").length());

            //在集合中查找
            int index = children.indexOf(thisNode);

            if (index == -1) {
                System.out.println("数据异常！");
            } else if (index == 0) {
                return;
            } else {
                //监听当前节点的前一个节点
                waitNode = "/" + rootNode + "/" + children.get(index - 1);
                zk.getData(waitNode, true, new Stat());

                //等待监听
                waitLath.await();
                return;

            }


        }

    }


    //开锁
    public void unZkLock() {

        try {
            zk.delete(subNode, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
