package ru.spbu.arts.java.oop.ascigraphics;
public class ImmutableDrawing {

    // данные картинки
    public int height = 1; //высота
    public int width = 1; //ширина
    public char symbol = '.';
    public char [][]image ;

    //конструктор для класса с символом
    public ImmutableDrawing (int height , int width , char symbol) {
        this.height = height;
        this.width = width;
        this.symbol = symbol;
        new_imege();
    }

    //конструктор для добавления рисунка
    public  ImmutableDrawing (int height , int width , char [][] image ) {
        this.height = height;
        this.width = width;
        this.image = image;
    }


    //конструктор для класса без символа
    public   ImmutableDrawing(int height , int width) {
        this.height = height;
        this.width = width;
        this.symbol = ' ';
        new_imege();
    }

    //заполнения массива картинки
    private void new_imege(){
        this.image = new char[this.height][this.width];
        for (int i = 0; i< this.height; i++) {
            for (int j = 0; j < this.width; j++){
                this.image[i][j] = this.symbol;
            }
        }
    }

    //печать на экране
    public void print(){
        for(int i = 0; i < this.height; i++) {
            String str = "";
            for (int j = 0; j < this.width; j++) {
                str += this.image[i][j];
                str += ' ';
            }
            System.out.println(str);
        }
    }

    //создание одного символа
    public  ImmutableDrawing setPoint(int x , int  y , char symbol){
        ImmutableDrawing newimage = new ImmutableDrawing(this.height, this.width, this.symbol);
        newimage.symbol = symbol;
        return  newimage;
    }

    //создание вертикальной линии
    public  ImmutableDrawing drawVerticalLine(int top_height , int bottom_height , int width , char symbol){
        ImmutableDrawing  newimage = new ImmutableDrawing(this.height,this.width, this.symbol);
        for (int i = top_height; i<bottom_height; i++) {
            newimage.symbol = symbol;
        }
        return  newimage;
    }

    //создание горизонтальной линии
    public  ImmutableDrawing drawHorizontalLine(int top_width , int bottom_width , int height , char symbol) {
        ImmutableDrawing  newimage = new ImmutableDrawing(this.height,this.width, this.symbol);
        for (int i = top_width; i < bottom_width; i++) {
            newimage.symbol = symbol;
        }
        return  newimage;
    }

    //создание прямоугольника
    public  ImmutableDrawing drawRectangle(int top_width , int bottom_width , int top_height , int bottom_height ,  char symbol){
        ImmutableDrawing  newimage = new ImmutableDrawing(this.height,this.width, this.symbol);
        for (int i = top_width; i <= bottom_width; i++) {
            newimage.image[i][top_height] = symbol;
        }
        for (int i = top_width; i <=bottom_width; i++) {
            newimage.image[bottom_height][i] = symbol;
        }
        for (int i = top_height; i <= bottom_height; i++) {
            newimage.image[i][top_width] = symbol;
        }
        for (int i = top_height; i <= bottom_height; i++) {
            newimage.image[bottom_width][i] = symbol;
        }
        return  newimage;
    }

    //вывод модуля (без библиотеки математики)
    public static double abs(double value) {
        return Double.longBitsToDouble(
                Double.doubleToRawLongBits(value) & 0x7fffffffffffffffL);
    }

    //создание произвольной линии
    public  ImmutableDrawing draw_line(int start_x , int start_y , int finish_x, int finish_y, char symbol) {
        ImmutableDrawing  newimage = new ImmutableDrawing(this.height,this.width, this.symbol);
        int deltax = (int) abs(finish_x - start_x);
        int deltay = (int) abs(finish_y - start_y);
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
            newimage.image[start_x][y] = symbol;
            error = error + deltaerr;
            if (error >= 1.0) {
                y = y + diry;
                error = (float) - 1.0;
            }
        }
        return newimage;
    }

    //создание окружности
    public  ImmutableDrawing draw_circle(int radius, int centre_x, int centre_y , char symbol) {
        ImmutableDrawing newimage = new ImmutableDrawing(this.height,this.width, this.symbol);
        int x = 0;
        int y = radius;
        int delta = 1 - 2 * radius;
        int error = 0;
        while (y >= 0) {
            newimage.image[centre_x + x][centre_y + y] = symbol;
            newimage.image[centre_x + x][centre_y - y] = symbol;
            newimage.image[centre_x - x][centre_y + y] = symbol;
            newimage.image[centre_x - x][centre_y - y] = symbol;
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
        return  newimage;
    }
    public ImmutableDrawing app_drawing(int x, int y, Drawing original) {
        ImmutableDrawing newimege = new ImmutableDrawing (this.height, this.width, this.image);
        for (int i = y; i < this.height; i++) {
            for (int j = x; j < this.width; j++) {
                newimege.image[j][i] = original.image[i-y][j-x];
            }
        }
        return newimege;
    }
    // возможные проблемы
    // не учтен выход за границу картинки
    // проблема случа 0 0 '/'

}
