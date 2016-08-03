package it.liuyang.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by yangliub on 2016/8/3.
 */
public class AsyncCreate {

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("master:2181", 5000, null);
        zk.create("/mas", "sid-02".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                new AsyncCallback.StringCallback() {

                    public void processResult(int rc, String path, Object ctx, String name) {
                        KeeperException.Code code = KeeperException.Code.get(rc);
                        switch (code) {
                            case OK: {
                                System.out.println(code);
                                break;
                            }
                            case NODEEXISTS: {
                                System.out.println(code);
                                break;
                            }
                            case SESSIONEXPIRED: {
                                System.out.println(code);
                                break;
                            }

                            default: {
                                System.out.println("unknown" + code);
                            }
                        }
                    }

                }, null);

        AsyncCallback.DataCallback callback = new AsyncCallback.DataCallback() {

            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                KeeperException.Code code = KeeperException.Code.get(rc);
                System.out.println("code for check " + code);
                switch (code) {
                    case OK:
                        break;
                    case NONODE:
                        break;
                    case NODEEXISTS:
                        break;
                    case SESSIONEXPIRED:
                        break;
                    default:
                }

            }

        };

        zk.getData("/mas", true, callback, null);
        Thread.sleep(200000);
    }


}
