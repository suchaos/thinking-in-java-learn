package com.suchaos.files;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Paths 的增删修改
 * <p>
 * 使用 relativize() 移除 Path 的根路径
 * <p>
 * 使用 resolve() 添加 Path 的尾路径
 *
 * @author suchao
 * @date 2020/2/24
 */
@Slf4j
public class AddAndSubtractPaths {

    static Path base = Paths.get("..", "files").toAbsolutePath().normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            log.info("( {} )r {}", id, base.relativize(result));
        } else {
            log.info("( {} ) {}", id, result);
        }
        try {
            log.info("RealPath: {}", result.toRealPath());
        } catch (IOException e) {
            log.error("toRealPath error: ", e);
        }
        log.info("**************************************");
    }

    public static void main(String[] args) {
        log.info(System.getProperty("os.name"));
        log.info(base.toString());
        Path p = Paths.get("src", "main", "java", "com", "suchaos", "files", "AddAndSubtractPaths.java")
                .toAbsolutePath();
        show(1, p);
        Path convoluted = p.getParent().getParent().resolve("strings").resolve("..")
                .resolve(p.getParent().getFileName());
        show(2, convoluted);
        show(3, convoluted.normalize());

        Path p2 = Paths.get("..");
        show(4, p2);
        show(5, p2.normalize());
        // TODO: 输出有问题
        show(6, p2.toAbsolutePath().normalize());

        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());

        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("string"));
        show(11, Paths.get("nonexistent"));
    }
}
