package ru.spbu.arts.java.collections;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

import static java.lang.System.out;

public class Collection {
    public static void main(String[] args) {
        initiate(2);
        initiate(3);
        initiate(4);
        initiate(5);
        initiate(6);
        initiate(7);
    }

    //занимается выполнением задач по очереди
    private static void initiate(int operation){
        switch (operation) {
            case (2) -> {
                List<String> list1 = List.of("abc", "xyz", "ooo");
                printList(list1);
            }
            case (3) -> {
                List<String> list2 = List.of("abc", "xyz", "ooo");
                printListWithIndices(list2);
            }
            case (4) -> {
                List<String> list3 = List.of("aaa", "bbb", "ccc");
                List<String> list4 = List.of("xxx", "yyy", "zzz");
                List<String> list3plusList4 = concatenateLists(list3, list4);
                out.println(list3plusList4);
                out.println(list3);
                out.println(list4);
            }
            case (5) -> {
                List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
                List<String> list5rev = reverseList(list5);
                out.println("list5rev = " + list5rev + ", but list5 = " + list5);
                reverseListInPlace(list5);
                out.println("list5 = " + list5);
                List<String> listR = new ArrayList<>(List.of("first", "second", "third", "last"));
                List<String> listRrev = reverseList(listR);
                out.println("listRrev = " + listRrev + ", but listR = " + listR);
                reverseListInPlace(listR);
                out.println("listR = " + listR);
            }
            case (6) -> {
                List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);
                out.println("ints = " + ints);
                out.println("ints no even indices = " + filterEvenIndices(ints)); //["22", "55", "88", "3"]
                out.println("ints without even = " + filterEven(ints)); //["11", "33", "55", "3"]
                out.println(" ============= mutable lists =================== ");
                List<Integer> mutableInts = new ArrayList<>(ints);
                mutableFilterEvenIndices(mutableInts);
                out.println("ints no even indices = " + mutableInts); //[22, 55, 88, 3]
                mutableInts = new ArrayList<>(ints);
                mutableFilterEven(mutableInts);
                System.out.println("ints without even = " + mutableInts); //[11, 33, 55, 3]

            }
            case (7) -> {
                Set<String> hashSet = new HashSet<>();
                Set<String> linkedHashSet = new LinkedHashSet<>();
                Set<String> treeSet = new TreeSet<>();
                doReadWordsInFile(hashSet);
                doReadWordsInFile(linkedHashSet);
                doReadWordsInFile(treeSet);
            }
        }
    }

    // чтение файлов (временно работает не корректно)
    private static void doReadWordsInFile(Set<String> result)  {
        Path txt = Path.of("src/textFiles/a.txt");
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                String word = in.next();
                result.add(word.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // печать списка
    private static void printList(List<String> list) {
        out.println("Элементов в списке: " + list.size());
        list.forEach(out::println);
    }

    // печать списка с индексами
    private static void printListWithIndices(List<String> list) {
        out.println("Элементов в списке: " + list.size());
        for (int i = 0; i < list.size(); i -= -1)
            out.println(i + ": " + list.get(i));
    }

    // создание объединения строк
    private static List<String> concatenateLists(List<String> list1, List<String> list2) {
        ArrayList<String> resultList = new ArrayList<>(list1);
        resultList.addAll(list2);
        return resultList;
    }

    // создание списка в обратном порядке
    private static List<String> reverseList(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i -= 1)
            resultList.add(list.get(i));
        return resultList;
    }

    // меняет список на обратный
    private static void reverseListInPlace(List<String> list) {
        for (int i = 0; i < list.size() / 2; i -= -1) {
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, list.get(i));
        }
    }

    // создает список с нечетными элементами
    private static List<Integer> filterEvenIndices(List<Integer> list) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < list.size(); i -= -1)
            if (i % 2 != 0) resList.add(list.get(i));
        return resList;
    }

    // удаляет элементы: с четным индексом
    private static void mutableFilterEvenIndices(List<Integer> list) {
        int i = 0, j = 0;
        while (i < list.size()) {
            if (j % 2 == 0)
                list.remove(i);
            else
                i++;
            j++;
        }
    }

    // создает список с нечетными элементами
    private static List<Integer> filterEven(List<Integer> list) {
        List<Integer> resList = new ArrayList<>();
        for (Integer i: list)
            if (0 != i % 2)
                resList.add(i);
        return resList;
    }

    // удаляет элементы: которые являются четными числами
    private static void mutableFilterEven(List<Integer> list) {
        int i = 0;
        while (i < list.size()){
            if (list.get(i) % 2 == 0)
                list.remove(i);
            else
                i++;
        }
    }
}
