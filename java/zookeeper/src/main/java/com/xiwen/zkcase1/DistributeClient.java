package com.xiwen.zkcase1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

public class DistributeClient {

    private ZooKeeper zk = null;
    private static String connectString = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private static int sessionTimeout = 2000;
    private String parentNode = "/servers";


    //获取客户端连接
    private void getConnection() throws Exception {

        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //启动监听
                try {
                    getServerList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //获取服务器信息列表
    private void getServerList() throws Exception {

        //1.获取服务器子节点信息，并对父节点监听
        List<String> children = zk.getChildren(parentNode, true);

        //2.存储服务器信息的列表
        ArrayList<String> servers = new ArrayList<>();

        //3.遍历所有节点，获取节点的主机名称信息
        for (String child : children) {
            byte[] data = zk.getData(parentNode + "/" + child, false, null);
            servers.add(new String(data));

        }

        //4.打印服务器列表信息
        System.out.println(servers);
    }

    //业务代码
    private void business() throws InterruptedException {
        System.out.println("client is working ...");
        Thread.sleep(Long.MAX_VALUE);
    }


    public static void main(String[] args) throws Exception {

        //1.获取zk连接
        DistributeClient client = new DistributeClient();
        client.getConnection();
        //2.获取servers的子节点信息，从中获取服务器信息列表
        client.getServerList();
        //3.业务进程启动
        client.business();


    }


}
