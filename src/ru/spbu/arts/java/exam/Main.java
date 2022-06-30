package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1 часть
        System.out.println("1");
        Files.walkFileTree(Paths.get("A:\\Progect_site"), new FileVisitor());
        // вывод "тип : путь статус
        // 2 часть
        System.out.println("2");
        FilesCollector fc = new FilesCollector();
        Files.walkFileTree(Path.of("A:\\Progect_site"), fc);
        String[] allFiles = fc.getAllFiles();
        // простите сделал строкой
        // 3 часть

    }
}

