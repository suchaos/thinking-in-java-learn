package com.suchaos.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * Files.write 写入 byte 数组或任何 Iterator 对象
 *
 * @author suchao
 * @date 2020/2/24
 */
public class Writing {

    static Random random = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws IOException {
        // write bytes to a file:
        byte[] bytes = new byte[SIZE];
        random.nextBytes(bytes);
        Files.write(Paths.get("bytes.dat"), bytes);
        System.out.println("bytes.dat: " + Files.size(Paths.get("bytes.dat")));

        // write an iterator to a file:
        List<String> lines = Files.readAllLines(Paths.get("pom.xml"), StandardCharsets.UTF_8);
        Files.write(Paths.get("Cheese.txt"), lines);
        System.out.println("cheese.txt: " + Files.size(Paths.get("Cheese.txt")));
    }
}
