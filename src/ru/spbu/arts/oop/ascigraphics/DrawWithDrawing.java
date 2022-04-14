package ru.spbu.arts.oop.ascigraphics;

public class DrawWithDrawing {
    public static void main(String[] args) {

        Drawing img = new Drawing(50, 50, '.');

        System.out.println("\n домик");
        img.drawRectangle(20,35,20,35,'*');
        img.draw_line(20,20,15,30,'*');
        img.draw_circle(4,5,5,'*');
        img.print();

    }
}
