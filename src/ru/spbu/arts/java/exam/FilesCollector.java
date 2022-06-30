package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesCollector extends SimpleFileVisitor<Path> {
    String string;


    public String[] getAllFiles() {
        System.out.println(this.string);
        return null;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.format("Directory: %s%n", dir);
        this.string += dir.getFileName();
        this.string += " : ";
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link: %s : ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular file: %s : ", file);
        } else {
            System.out.format("Other: %s : ", file);
        }
        System.out.println("found a file");
        this.string += file.getFileName();
        this.string += ",";
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.format("Directory: %s%n", dir);
        this.string += "; ";
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("error a file");
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
}
