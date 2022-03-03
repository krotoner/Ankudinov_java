package ru.spbu.arts.java.oop.rational;
public class Rational {

    //данный дроби
    private double numerator;
    private double denominator;

    //конструктор для класса
    public void Drawing(int numerator , int denominator) {
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
        else if (this.denominator == 0 || this.numerator == 0){
            result += 0;
        }
        else if (this.numerator < 0 || this.denominator < 0){
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
        return result;

    }

}