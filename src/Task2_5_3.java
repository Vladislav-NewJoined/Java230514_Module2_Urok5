import java.util.Arrays;

public class Task2_5_3 {
    public static void main(String[] args) {
        System.out.println("Задание: \n3.\tСохраните 10 строк в массив, выведите с конца каждую вторую\n\nРешение: ");

        System.out.println("Сохраняем 10 строк в массив: ");
        String[] a = new String[10];
        a[0] = "Строка один";
        a[1] = "Строка два";
        a[2] = "Строка три";
        a[3] = "Строка четыре";
        a[4] = "Строка пять";
        a[5] = "Строка шесть";
        a[6] = "Строка семь";
        a[7] = "Строка восемь";
        a[8] = "Строка девять";
        a[9] = "Строка десять";

        System.out.println(Arrays.toString(a));
        System.out.println();
        System.out.println("Выводим с конца каждую вторую");

        for (int i = 8; i >= 0; i = i - 2) {
            System.out.println(a[i]);
        }
    }
}
