package com.haoyoungde;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int _1MB = 1024 * 1024;
    byte[] bigSize = new byte[2 * _1MB];
    public Object instance = null;

    public static void main(String[] args) {
        try (
                Options options = new Options().setCreateIfMissing(true);
                RocksDB rocksdb = RocksDB.open(options, "db")
        ){
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.execute(() -> {
                for(int i = 0; i < 500000; i++){
                    byte[] key = new byte[1024];
                    byte[] value = new byte[1024];
                    try {
                        rocksdb.put(key, value);
                    } catch (RocksDBException e) {
                        e.printStackTrace();
                    }
                    Main a = new Main();
                    Main b = new Main();
                    a.instance = b;
                    b.instance = a;
                    a=null;
                    b=null;
                }
            });
            executorService.shutdown();
            while (!executorService.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("等待任务结束");
            }
            System.in.read();
        } catch (RocksDBException | IOException | InterruptedException e) {
                e.printStackTrace();
        }
    }
}
