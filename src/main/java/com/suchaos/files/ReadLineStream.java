package com.suchaos.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Files.lines() 方便将文件转化为行的 stream
 *
 * @author suchao
 * @date 2020/2/24
 */
public class ReadLineStream {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("pom.xml"))
                .skip(13)
                .findFirst()
                .ifPresent(System.out::print);
    }
}
