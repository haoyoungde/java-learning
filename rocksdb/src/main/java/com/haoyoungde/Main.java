package com.haoyoungde;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

import java.io.IOException;

public class Main {
    private static final int _1MB = 1024 * 1024;
    byte[] bigSize = new byte[2 * _1MB];
    public Object instance = null;

    public static void main(String[] args) {
        try (
                Options options = new Options().setCreateIfMissing(true);
                RocksDB rocksdb = RocksDB.open(options, "db")
        ){
            for(int i = 0; i < Integer.MAX_VALUE; i++){
                byte[] key = new byte[1024];
                byte[] value = new byte[1024];
                rocksdb.put(key, value);
                Main a = new Main();
                Main b = new Main();
                a.instance = b;
                b.instance = a;
                a=null;
                b=null;
            }
            System.in.read();
        } catch (RocksDBException | IOException e) {
                e.printStackTrace();
        }
    }
}
