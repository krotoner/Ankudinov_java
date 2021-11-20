import static java.lang.Math.sqrt;

class Task6 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 1;
        double x1 = 0;
        double x2 = 0;
        int d = b^2 - 4*a*c;
        if (a == 0)
            System.out.println(-(b/c));
        else if (d < 0)
            System.out.println("корней нет");
        else if (d == 0)
            System.out.println(((-b)/2*a));
        else if (d > 0) {
            x1 = ((-b) - sqrt(d)) / (2 * a);
            x2 = ((-b) + sqrt(d)) / (2 * a);
            if (x1 > x2)
                System.out.println(x2 + x1);
            else
                System.out.println(x1 + x2);
        }
    }
}
