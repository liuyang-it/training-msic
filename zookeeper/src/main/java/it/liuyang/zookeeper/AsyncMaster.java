package it.liuyang.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by yangliub on 2016/8/3.
 */
public class AsyncMaster implements Watcher, Runnable {

    private ZooKeeper zk;

    private String connectString;

    private String serverId;

    private static final String MASTER_PATH = "/master";

    public AsyncMaster(String connectString, String serverId) {
        this.connectString = connectString;
        this.serverId = serverId;
    }

    public void run() {

    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public void start() {
        try {
            zk = new ZooKeeper(connectString, 2000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
