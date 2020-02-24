package com.suchaos.files;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 测试删除目录树的方法
 *
 * @author suchao
 * @date 2020/2/24
 */
@Slf4j
public class Directories {

    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path thisFilePath = Paths.get("src", "main", "java", "com", "suchaos", "files", "Directories.java");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws IOException {
        if (Files.exists(test)) {
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {
            Files.createDirectory(test);
        }
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();

        try {
            Files.createDirectory(variant);
        } catch (IOException e) {
            log.error("Nope, that doesn't work.");
        }

        populateTestDir();

        Path tempdir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempdir, "pre", ".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("*********************");
        Files.walk(test).forEach(System.out::println);
    }

    static void populateTestDir() throws IOException {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (!Files.exists(variant)) {
                Files.createDirectories(variant);
                Files.copy(thisFilePath, variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }
}
