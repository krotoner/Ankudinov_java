package ru.spbu.arts.java.oop.rational
class Rational{

    //данный дроби
    private double numerator;
    private double denominator;

    //конструктор для класса
    public void Drawing(int numerator , int denominator = 1) {
        this.numerator =  numerator;
        if (denominator != 1) {
            this.denominator = denominator;
        }
        else {
            this.denominator = 1;
        }
    }

    //естественное представление числа в виде строки
    public String toString(){
        String result = "";
        if (this.denominator == 1) {
            result += this.numerator;
        }
        if else ((this.denominator == 0) || (this.numerator == 0)){
            result += 0;
        }
        if else ((this.numerator < 0) || (this.denominator < 0)){
            result += "-";
            result += this.numerator;
            result += "/";
            result += this.denominator;
        }
        else{
            result += this.numerator;
            result += "/";
            result += this.denominator;
        }
    }
}