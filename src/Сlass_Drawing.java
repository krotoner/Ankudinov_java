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

    // отрисовка одного символа
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

    public static void main(String[] args) {
        Drawing img = new Drawing(10, 10);
        img.drawVerticalLine(2,8,3,'*');
        img.print();
    }

    // возможные проблемы
    // не учтен выход за границу картинки
}
