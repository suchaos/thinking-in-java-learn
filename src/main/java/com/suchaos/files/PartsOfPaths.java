package com.suchaos.files;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 选取路径部分片段
 *
 * @author suchao
 * @date 2020/2/24
 */
@Slf4j
public class PartsOfPaths {

    public static void main(String[] args) {
        log.info(System.getProperty("os.name"));
        Path p = Paths.get("src", "main", "java", "com", "suchaos", "files", "PartsOfPaths.java")
                .toAbsolutePath();
        for (int i = 0; i < p.getNameCount(); i++) {
            log.info("name: {}", p.getName(i));
        }
        log.info("ends with '.java' {}", p.endsWith(".java"));
        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + ": ");
            System.out.println(p.endsWith(pp));
        }
        log.info("Starts with {} {}", p.getRoot(), p.startsWith(p.getRoot()));
    }
}
