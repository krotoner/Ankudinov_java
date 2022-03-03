package ru.spbu.arts.java.oop.ascigraphics;
public class Drawing {

    // ������ ��������
    public int height = 1; //������
    public int width = 1; //������
    public char symbol = '.';
    public char [][]image ;

    //����������� ��� ������ � ��������
    public  Drawing(int height , int width , char symbol) {
        this.height = height;
        this.width = width;
        this.symbol = symbol;
        new_imege();
    }

    //����������� ��� ���������� �������
    public  Drawing(int height , int width , char [][] image ) {
        this.height = height;
        this.width = width;
        this.image = image;
    }


    //����������� ��� ������ ��� �������
    public  Drawing(int height , int width) {
        this.height = height;
        this.width = width;
        this.symbol = ' ';
        new_imege();
    }

    //���������� ������� ��������
    private void new_imege(){
        this.image = new char[this.height][this.width];
        for (int i = 0; i< this.height; i++) {
            for (int j = 0; j < this.width; j++){
                this.image[i][j] = this.symbol;
            }
        }
    }

    //������ �� ������
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

    //�������� ������ �������
    public void setPoint(int x , int  y , char symbol){
        this.image[x][y] = symbol;
    }

    //�������� ������������ �����
    public void drawVerticalLine(int top_height , int bottom_height , int width , char symbol){
        for (int i = top_height; i<bottom_height; i++){
            setPoint(i, width, symbol);
        }
    }

    //�������� �������������� �����
    public void drawHorizontalLine(int top_width , int bottom_width , int height , char symbol) {
        for (int i = top_width; i < bottom_width; i++) {
            setPoint(i, height, symbol);
        }
    }

    //�������� ��������������
    public void drawRectangle(int top_width , int bottom_width , int top_height , int bottom_height ,  char symbol){
        drawHorizontalLine(top_width , bottom_width , top_height , symbol);
        drawHorizontalLine(top_width , bottom_width , bottom_height , symbol);
        drawVerticalLine(top_height , bottom_height , top_width , symbol);
        drawVerticalLine(top_height , bottom_height , bottom_width , symbol);
    }

    //����� ������ (��� ���������� ����������)
    public static double abs(double value) {
        return Double.longBitsToDouble(
                Double.doubleToRawLongBits(value) & 0x7fffffffffffffffL);
    }

    //�������� ������������ �����
    public void draw_line(int start_x , int start_y , int finish_x, int finish_y, char symbol) {
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
            setPoint(x, y, symbol);
            error = error + deltaerr;
            if (error >= 1.0) {
                y = y + diry;
                error = (float) - 1.0;
            }
        }
    }

    //�������� ����������
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
    public void app_drawing(int x, int y, Drawing original) {
        Drawing newimege = new Drawing (this.height, this.width, this.image);
        for (int i = y; i < this.height; i++) {
            for (int j = x; j < this.width; j++) {
                newimege.image[j][i] = original.image[i-y][j-x];
            }
        }
    }
    // ��������� ��������
    // �� ����� ����� �� ������� ��������
    // �������� ����� 0 0 '/'

}
