import java.util.Arrays;
import java.util.Scanner;

public class Task2_5_1 {
    public static void main(String[] args) {
        System.out.println("Задание: \n1.\tПользователь вводит 10 чисел, сохраните их в массив\n\nРешение: ");
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите 10 целых чисел, разделителем является нажатие Enter: ");

        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("Вы ввели 10 чисел. Они сохранены в следующий массив: ");
        System.out.println(Arrays.toString(a));
    }
}
