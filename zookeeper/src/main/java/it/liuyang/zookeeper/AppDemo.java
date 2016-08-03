package it.liuyang.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by yangliub on 2016/8/3.
 */
public class AppDemo {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("master:2181",
                5000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });

      //  zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
      //          CreateMode.PERSISTENT);

     //   zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        // 取出子目录节点列表
       // System.out.println(new String(zk.getData("/testRootPath", false, null)));

        //修改子目录节点数据
      //  zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);

       // System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");

     //   zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    //    System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));

      //  zk.delete("/testRootPath/testChildPathTwo", -1);

        //zk.delete("/testRootPath/testChildPathOne", -1);

        zk.delete("/testRootPath",-1);


    }

}
