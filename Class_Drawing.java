class Drawing {

    // данные картинки
    public int height = 1; //высота
    public int width = 1; //ширина
    public char symbol = ".";
    public char imege = [][];

    //конструктор для класса
    public void Drawing(int height , int width , int symbol) {
        this.height = height;
        this.width = width;
        this.symbol = symbol;
        new_imege();
    }

    //заполнения массива картинки
    public void new_imege(){
        for(int i = 0; i < this.height; i++){
            for(int i = 0; i < this.width; i++){
                this.imege[i][j] = this.symbol;
            }
        }
    }

    //печать на экране
    public void print(){
        System.out.println(this.imege);
    }

    // отрисовка одного символа
    public void setPoint(int x , int  y , char symbol = "*"){
        this.imege[x][y] = symbol;
    }

    //создание вертикальной линии
    public void drawVerticalLine(int top_height , int bottom_height , int width , int symbol = "*"){
        for (i = top_height; i<bottom_height; i++){
            setPoint(i, width, symbol);
        }
    }

    //создание горизонтальной линии
    public void drawHorizontalLine(int top_width , int bottom_width , int height , int symbol = "*") {
        for (i = top_height; i < bottom_height; i++) {
            setPoint(i, height, symbol);
        }
    }

    //создание прямоугольника
    public void drawRectangle(int top_width , int bottom_width , int top_height , int bottom_height ,  int symbol = "*"){
        drawHorizontalLine(top_width , bottom_width , top_height , symbol);
        drawHorizontalLine(top_width , bottom_width , bottom_height , symbol);
        drawVerticalLine(top_height , bottom_height , top_width , symbol);
        drawVerticalLine(top_height , bottom_height , bottom_width , sombol);
    }

    public static void main(String[] args) {

    }
}
