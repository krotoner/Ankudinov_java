package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    //просто класс main
    public static void main(String[] args) {
        Time breakfast = new Time(9, 25);
        Time lunch = new Time(14, 00);
        Time dinner = new Time(18, 34);
        Time good_higt = new Time(22, 50);

        breakfast.printer();
        lunch.printer();
        dinner.printer();
        good_higt.printer();
        good_higt.add(30);
        good_higt.printer();

        //предпологается выдача:
        //Доброе утро сейчас 9 : 25
        //Добрый день сейчас 14 : 00
        //Добрый вечер сейчас 18 : 34
        //Добрый вечер сейчас 22 : 50
        //time update 30
        //Доброй ночи сейчас 23 : 20
    }
}
