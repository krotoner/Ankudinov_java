package ru.spbu.arts.java.oop.time;
class Time {

    // формат времени 24 часа 60 минут
    public int hour;
    public int minute;

    //конструктор для класса time
    public Time(int hour , int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    // запись времени через ":"
    public String show(){
        String output = "";
        if (this.hour > 9 && this.minute > 9){
            output +=  this.hour + " : " +  this.minute;
        }
        else if (this.hour <= 9 && this.minute > 9){
            output +=  "0" + this.hour + " : " +  this.minute;
        }
        else if (this.hour > 9 && this.minute <= 9){
            output +=  this.hour + " : " +  "0"  +this.minute;
        }
        else if (this.hour <= 9 && this.minute <= 9){
            output +=  "0" + this.hour + " : " +  "0" + this.minute;
        }
        return output;
    }

    // проверка на время суток
    public boolean isDay(){

        if (this.hour>=12 && this.hour<18){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isMorning(){
        if (this.hour >=6 && this.hour<12){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isEvening(){
        if (this.hour>=18 && this.hour<23){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isNight(){
        if (this.hour>=23 || this.hour<5){
            return true;
        }
        else{
            return false;
        }
    }

    // создание пожелания времени суток
    public String sayHello(){
        int time = this.hour;
        if (isMorning()){

            return "Доброе утро";
        }
        else if (isDay()){
            return "Добрый день";
        }
        else if (isEvening()){
            return "Добрый вечер";
        }
        else if (isNight()){
            return "Доброй ночи";
        }
        else {
            return "Доброго времени суток ))";
        }
    }

    // добавление времени
    public void add(int add_minets){
        this.minute += add_minets;
        if (this.minute >= 60){
            this.hour += this.minute / 60;
            this.minute = this.minute % 60;
            if (this.hour >= 24){
                this.hour = this.hour % 24;
            }
        }
        System.out.println("time update "+add_minets);
    }

    // вывод с пожеланием
    public void printer(){
        String greeting = sayHello();
        String time = show();
        System.out.println(greeting + " сейчас " + time);
    }

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
