package com.haoyoungde;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.WriteOptions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try (
                final Options options = new Options().setCreateIfMissing(true);
                final RocksDB rocksdb = RocksDB.open("rocksdb")
        ){
            byte[] key = new byte[1024];
            byte[] value = new byte[1024];
            rocksdb.put(key, value);
            System.in.read();
        } catch (RocksDBException | IOException e) {
                e.printStackTrace();
        }
    }
}
