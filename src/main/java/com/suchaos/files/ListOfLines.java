package com.suchaos.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Files.readAllLines() 一次读取整个文件
 *
 * @author suchao
 * @date 2020/2/24
 */
public class ListOfLines {

    static Path THIS_FILE_PATH = Paths.get("src", "main", "java", "com", "suchaos", "files", "ListOfLines.java");

    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(THIS_FILE_PATH, StandardCharsets.UTF_8);
        list.stream().filter(line -> !(line.startsWith("/") || line.startsWith("*")))
                .map(line -> line.substring(0, line.length() / 2))
                .forEach(System.out::println);
    }
}
