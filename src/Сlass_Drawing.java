class Drawing {
    // ������ ��������
    public int height = 1; //������
    public int width = 1; //������
    public char symbol = '.';
    public char [][]imege ;

    //����������� ��� ������ � ��������
    public  Drawing(int height , int width , char symbol) {
        this.height = height;
        this.width = width;
        this.symbol = symbol;
        new_imege();
    }

    //����������� ��� ������ ��� �������
    public  Drawing(int height , int width) {
        this.height = height;
        this.width = width;
        this.symbol = ' ';
        new_imege();
    }

    //���������� ������� ��������
    public void new_imege(){
        this.imege = new char[this.height][this.width];
        for (int i = 0; i< this.height; i++) {
            for (int j = 0; j < this.width; j++){
                this.imege[i][j] = this.symbol;
            }
        }
    }

    //������ �� ������
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

    // ��������� ������ �������
    public void setPoint(int x , int  y , char symbol){
        this.imege[x][y] = symbol;
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

    public static void main(String[] args) {
        Drawing img = new Drawing(10, 10);
        img.drawVerticalLine(2,8,3,'*');
        img.print();
    }

    // ��������� ��������
    // �� ����� ����� �� ������� ��������
}
