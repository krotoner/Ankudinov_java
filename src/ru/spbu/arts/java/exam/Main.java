package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("A:\\Progect_site"), new FileVisitor());
    }
}

