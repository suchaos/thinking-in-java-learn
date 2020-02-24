package com.suchaos.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * 文件查找 -- 使用 PathMatcher
 * <p>
 * 使用 glob 查找以 .tmp 和 .txt 结尾的所有 Path
 * <p>
 * Java 语言 Glob 语法规则 -- https://busy.im/post/java-glob-syntax/
 *
 * @author suchao
 *
 * @date 2020/2/24
 */
public class Find {

    public static void main(String[] args) throws IOException {
        Path test = Paths.get("test");
        Directories.refreshTestDir();
        Directories.populateTestDir();

        // 创建一个目录，而不是文件
        Files.createDirectory(test.resolve("dir.tmp"));

        // **/ 表示在当前目录及所有子目录， * 表示任何东西， 大括号表示所有的可能性
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{tmp,txt}");

        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);
        System.out.println("********************************");

        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:*.tmp");
        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
        System.out.println("********************************");

        // only look for files
        Files.walk(test)
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
