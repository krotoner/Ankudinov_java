package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1 часть
        System.out.println("1");
        Files.walkFileTree(Paths.get("A:\\Progect_site"), new FileVisitor());
        // вывод "тип : путь : статус"

        // 2.1 часть
        System.out.println("2");
        FilesCollector fc = new FilesCollector();
        Files.walkFileTree(Path.of("A:\\Progect_site"), fc);
        List<Path> allFiles = fc.getAllFiles();
        System.out.println(allFiles);
        // простите сделал строкой

        // 2.2 часть
        Map<String, List<Path>> allFilesByExtension = fc.getFilesByExtension();


        // 3 часть

    }
}

