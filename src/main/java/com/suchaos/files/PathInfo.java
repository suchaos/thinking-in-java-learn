package com.suchaos.files;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件和目录路径
 * <p>
 * https://lingcoder.gitee.io/onjava8/#/book/17-Files
 *
 * @author suchao
 * @date 2020/2/24
 */
@Slf4j
public class PathInfo {

    static void show(String id, Object p) {
        log.info("{} : {}", id, p);
    }

    static void info(Path path) {
        show("toString", path);
        show("Exists", Files.exists(path));
        show("RegularFile", Files.isRegularFile(path));
        show("Directory", Files.isDirectory(path));
        show("Absolute", path.isAbsolute());
        show("FileName", path.getFileName());
        show("Parent", path.getParent());
        show("Root", path.getRoot());
        log.info("*************************************");
    }

    public static void main(String[] args) {
        log.info(System.getProperty("os.name"));
        info(Paths.get("C:", "path", "to", "nowhere", "Nofile.txt"));
        Path p = Paths.get("src", "main", "java", "com", "suchaos", "files", "PathInfo.java");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        try {
            info(p.toRealPath());
        } catch (IOException e) {
            log.error("toRealPath error", e);
        }
        URI u = p.toUri();
        log.info("URI: {}", u);
        Path puri = Paths.get(u);
        log.info("Files.exists(puri) is {}", Files.exists(puri));

        File f = ap.toFile();
    }
}
