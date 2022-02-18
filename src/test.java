class App {
    public char [][]imege;


    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[][] imege= new String[8][8];
        for (int i = 0; i < imege.length; i++) {
            for (int j = 0; j < imege[0].length; j++) {
                imege[i][j] = "W";

            }
        }
        for (int i = 0; i < imege.length; i++) {
            String str = "";
            for (int j = 0; j < imege[0].length; j++)
                str += imege[i][j];
            System.out.println(str);

        }
    }


}