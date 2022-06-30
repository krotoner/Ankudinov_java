package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilesCollector extends SimpleFileVisitor<Path> {
    String string;
    List list = new ArrayList();
    List Count_type = new ArrayList();
    List Name_type = new ArrayList();
    List result = new ArrayList();


    public List<Path> getAllFiles() {
        //System.out.println(this.string);
        //System.out.println(this.list);
        return this.list;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.format("Directory: %s%n", dir);
        this.string += dir.getFileName();
        this.string += " : ";
        this.list.add(dir.getFileName());
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
        this.list.add(file.getFileName());


        this.Name_type.add(file.getFileName());
        this.Count_type.add(file.getNameCount());

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

    public Map<String, List<Path>> getFilesByExtension() {
        System.out.println(this.Count_type);
        System.out.println(this.Name_type);
        for (int i = 0; i < this.Name_type.size(); i++){
            this.result.add(this.Name_type);
            this.result.add(this.Count_type);
        }
        System.out.println(this.result);
        return null;
    }
}
