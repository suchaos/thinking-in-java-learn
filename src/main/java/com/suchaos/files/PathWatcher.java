package com.suchaos.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 路径监听
 *
 * @author suchao
 * @date 2020/2/24
 */
public class PathWatcher {

    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));

        WatchService watcher = FileSystems.getDefault().newWatchService();
        test.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor().
                schedule(PathWatcher::delTxtFiles, 250, TimeUnit.MILLISECONDS);
        WatchKey key = watcher.take();
        for (WatchEvent evt : key.pollEvents()) {
            System.out.println("evt.econtext(): " + evt.context()
                    + "\nevt.count(): " + evt.count()
                    + "\nevt.kind(): " + evt.kind()
            );
            System.out.println(Thread.currentThread().getName());
        }
    }
}
