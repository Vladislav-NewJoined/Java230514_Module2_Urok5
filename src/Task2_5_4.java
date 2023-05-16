import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2_5_4 {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Задание: \n4.\tВ файле 10 дробных чисел. Считайте в массив, выведите те, что больше числа пи.\n\nРешение: ");

        // Считываем переменные double из файла по адресу: \\10_doubles.txt
        System.out.println("Создаем файл txt. В нем 10 дробных чисел. Файл создан в корневом каталоге проекта по адресу: \\10_doubles.txt");
        System.out.println("В файле содержатся следующие переменные: [4.353, 8.121, 1.233, 5.637, 3.001, 4.286, 2.367, 4.551, 2.992, 5.777]");
        System.out.println("Выводим те переменные, которые больше числа пи: ");
        System.out.println();

        FileReader fileReader = new FileReader("10_doubles.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        Double[] part = new Double[10];
        Double pi = Math.PI;

        for (int i=0; i<10; i++) {
            part [i] = Double.valueOf(reader.readLine());
            if (part [i] > pi) {
                System.out.println(part [i]);
            }
        }
    }
}
