class ArraysTasks {
    // 1  Дано n, верните массив из первых n четных чисел: 2 4 6 8 … 2n
    public static int[] func1() {
        int n = 20;
        int k = 2;
        int[] Array_1 = new int[10];
        for (int i = 0; i < n; i++) {
            Array_1[i] = k;
            k += 2;
        }
        System.out.println(Array_1);
        return Array_1;
    }

    // 2 boolean allSimilar(int[] a). Дан массив чисел, проверьте, что в массиве все числа одинаковые.
    // Если в массиве меньше двух элементов, тоже считается, что все числа одинаковые.
    public static boolean allSimilar(int[] a) {
        int[] Array_2 = a;
        int n = Array_2.length;
        if (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                if (Array_2[i] != Array_2[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        else {
            return true;
        }
    }
    //3 Дан массив, функция проверяет, есть ли в массиве одинаковые элементы: boolean hasSimilar(int[] a)
    public static boolean hasSimilar(int[] a){
        int[] Array_3 = a;
        int n = Array_3.length;
        for (int i = 0; i < n - 1; i++) {
            int k = 0;
            for (int j = 0; i < n - 1; i++) {
                if (Array_3[i] == Array_3[j]) {
                    k++;
                }
            }
            if (k > 0) {
                return true;
            }
        }
        return false;
    }
    //4 double mean(int[] a). Дан массив, верните среднее значение всех элементов массива. (т.е. сумму элементов, деленную на количество элементов)
    public static double mean(int[] a){
        int[] Array_4 = a;
        int n = Array_4.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += Array_4[i];
        }
        int result = 0;
        result = sum / n;
        return result;
    }
    //5 void shift(int[] a). Дан массив, верните новый массив, в котором элементы сдвинуты по циклу направо. Например, массив {10, 20, 30, 40}
    // должен превратиться в {40, 10, 20, 30}. Обратите внимание, что функция не возвращает результат, она меняет переданный ей массив.
    public static int[] shift(int[] a){
        int[] Array_5 = a;
        int n = Array_5.length;
        int[] Array_6 = new int[n];
        int j = 1;
        for (int i = 0; i < n-1; i++){
            Array_6[j] = Array_5[i];
            j++;
        }
        Array_6[0] = Array_5[n];
        return Array_6;

    }
    //6 int[] copyShift(int[] a), задание аналогично предыдущему, но вы должны не менять переданный массив, а вернуть новый массив.
    // эммм эти задания одинаковы и там и там новый
    // вызов всего и вся
    public static void main(String[] args) {  //основной блок программы
        int[] a = new int[10];
        System.out.println(func1());
        System.out.println(allSimilar(a));
        System.out.println(hasSimilar(a));
        System.out.println(mean(a));
        System.out.println(shift(a));
    }
}
