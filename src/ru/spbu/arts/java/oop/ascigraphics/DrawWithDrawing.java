package ru.spbu.arts.java.oop.ascigraphics;

public class DrawWithDrawing {
    public static void main(String[] args) {

        Drawing img = new Drawing(30, 50, '.');

        System.out.println("\n домик");

        img.draw_circle(3,30,5, '*');
        img.drawRectangle(6,15,35,24, '*');
        img.drawRectangle(25,8,33,15, '*');
        img.draw_line(6,15,15,5, '*');
        img.draw_line(15,6,25,21, '*');
        img.drawRectangle(10,18,14,24,'*');
        img.drawRectangle(24,17,30,22,'*');
        img.print();

    }
}
