package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    //������ ����� main
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

        //�������������� ������:
        //������ ���� ������ 9 : 25
        //������ ���� ������ 14 : 00
        //������ ����� ������ 18 : 34
        //������ ����� ������ 22 : 50
        //time update 30
        //������ ���� ������ 23 : 20
    }
}
