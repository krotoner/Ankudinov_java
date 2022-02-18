//package java.math;

import static java.lang.Math.*;
class Drawing {
    // данные картинки
    public int height = 1; //высота
    public int width = 1; //ширина
    public char symbol = '.';
    public char [][]imege ;

    //конструктор для класса с символом
    public  Drawing(int height , int width , char symbol) {
        this.height = height;
        this.width = width;
        this.symbol = symbol;
        new_imege();
    }

    //конструктор для класса без символа
    public  Drawing(int height , int width) {
        this.height = height;
        this.width = width;
        this.symbol = ' ';
        new_imege();
    }

    //заполнения массива картинки
    public void new_imege(){
        this.imege = new char[this.height][this.width];
        for (int i = 0; i< this.height; i++) {
            for (int j = 0; j < this.width; j++){
                this.imege[i][j] = this.symbol;
            }
        }
    }

    //печать на экране
    public void print(){

        for(int i = 0; i < this.height; i++) {
            String str = "";
            for (int j = 0; j < this.width; j++) {
                str += this.imege[i][j];
                str += ' ';
            }
            System.out.println(str);
        }
    }

    //создание одного символа
    public void setPoint(int x , int  y , char symbol){
        this.imege[x][y] = symbol;
    }

    //создание вертикальной линии
    public void drawVerticalLine(int top_height , int bottom_height , int width , char symbol){
        for (int i = top_height; i<bottom_height; i++){
            setPoint(i, width, symbol);
        }
    }

    //создание горизонтальной линии
    public void drawHorizontalLine(int top_width , int bottom_width , int height , char symbol) {
        for (int i = top_width; i < bottom_width; i++) {
            setPoint(i, height, symbol);
        }
    }

    //создание прямоугольника
    public void drawRectangle(int top_width , int bottom_width , int top_height , int bottom_height ,  char symbol){
        drawHorizontalLine(top_width , bottom_width , top_height , symbol);
        drawHorizontalLine(top_width , bottom_width , bottom_height , symbol);
        drawVerticalLine(top_height , bottom_height , top_width , symbol);
        drawVerticalLine(top_height , bottom_height , bottom_width , symbol);
    }

    //создание произвольной линии
    public void draw_line(int start_x , int start_y , int finish_x, int finish_y, char symbol) {
        int deltax = abs(finish_x - start_x);
        int deltay = abs(finish_y - start_y);
        float error = 0;
        int deltaerr = (deltay + 1) / (deltax + 1);
        int y = start_y;
        int diry = finish_y - start_y;
        if (diry > 0) {
            diry = 1;
        }
        if (diry< 0) {
            diry = -1;
        }
        for (int x = start_x ;x < finish_x ; x++) {
            setPoint(x, y, symbol);
            error = error + deltaerr;
            if (error >= 1.0) {
                y = y + diry;
                error = (float) - 1.0;
            }
        }
    }

    //создание окружности
    public void draw_circle(int radius, int centre_x, int centre_y , char symbol) {
        int x = 0;
        int y = radius;
        int delta = 1 - 2 * radius;
        int error = 0;
        while (y >= 0) {
            setPoint(centre_x + x, centre_y + y, symbol);
            setPoint(centre_x + x, centre_y - y, symbol);
            setPoint(centre_x - x, centre_y + y, symbol);
            setPoint(centre_x - x, centre_y - y, symbol);
            error = 2 * (delta + y) - 1;
            if ((delta < 0) && (error <= 0)) {
                x += 1;
                delta = delta + (2 * x + 1);
                error = (2 * (delta - x)) - 1;
            }
            else if ((delta > 0) && (error > 0)) {
                y -= 1;
                delta = delta + (1 - 2 * y);
                x += 1;
            }
            else
                delta = delta + (2 * (x - y));
                y -= 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("\nДомик");
        Drawing img2 = new Drawing(30, 50);

        img2.print();
    }


    // возможные проблемы
    // не учтен выход за границу картинки

}
