package com.suchaos.files;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * 使用 Files 中的一系列方法来进行路径分析
 *
 * @author suchao
 * @date 2020/2/24
 */
@Slf4j
public class PathAnalysis {

    static void say(String id, Object p) {
        log.info("{} : {}", id, p);
    }

    public static void main(String[] args) throws IOException {
        log.info(System.getProperty("os.name"));
        Path p = Paths.get("files", "src", "main", "java", "com", "suchaos", "files", "PathAnalysis.java")
                .toAbsolutePath();
        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isReadable(p));
        say("RegularFile", Files.isRegularFile(p));
        say("Writable", Files.isWritable(p));
        say("notExists", Files.notExists(p));
        say("hidden", Files.isHidden(p));
        say("size", Files.size(p));
        say("FileStore", Files.getFileStore(p));
        say("LastModified", Files.getLastModifiedTime(p));
        say("Owner", Files.getOwner(p));
        say("ContentType", Files.probeContentType(p));
        say("SymbolicLink", Files.isSymbolicLink(p));
        if (Files.isSymbolicLink(p)) {
            say("SymbolicLink", Files.readSymbolicLink(p));
        }
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermissions", Files.getPosixFilePermissions(p));
        }
    }
}
