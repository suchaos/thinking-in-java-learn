package com.suchaos.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 在 stream 中读取，处理或写入
 *
 * @author suchao
 * @date 2020/2/24
 */
public class StreamInAndOut {

    public static void main(String[] args) {
        try (Stream<String> input = Files.lines(Paths.get("pom.xml"));
             PrintWriter output = new PrintWriter("StreamInAndOut.txt")) {
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
