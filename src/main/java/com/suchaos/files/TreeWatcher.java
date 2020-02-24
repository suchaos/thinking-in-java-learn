package com.suchaos.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;

/**
 * 监听整个树目录
 *
 * @author suchao
 * @date 2020/2/24
 */
public class TreeWatcher {

    static void watchDir(Path dir) {
        try {
            //System.out.println("watchDir: " + dir);
            WatchService wathcer = FileSystems.getDefault().newWatchService();
            dir.register(wathcer, StandardWatchEventKinds.ENTRY_DELETE);
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    WatchKey key = wathcer.take();
                    for (WatchEvent evt : key.pollEvents()) {
                        System.out.println("evt.econtext(): " + evt.context()
                                + "\nevt.count(): " + evt.count()
                                + "\nevt.kind(): " + evt.kind()
                        );
                        System.out.println(Thread.currentThread().getName());
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        //System.out.println("foreach: " + f);
        Files.walk(Paths.get("test"))
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchDir);
        PathWatcher.delTxtFiles();
    }
}
