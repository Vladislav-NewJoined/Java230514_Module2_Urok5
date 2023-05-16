import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;


public class Task2_5_6 {
    public static void main(String[] args) throws IOException {
        System.out.println("Задание: \n6.\tЕсть 2 файла по 5 строк в каждом. Сохраните их в 2 массива. Создайте третий " +
                "массив из 10 строк, скопируйте в него строки из первых двух массивов.\n\nРешение: ");

        System.out.println("Создаем два файла txt в корневом каталоге проекта по адресу: \\file1_for_Task6.txt, \\file1_for_Task6.txt. В каждом по 5 строк.");
        System.out.println("Сохраняем строки из файлов в два массива");
        System.out.println("Содержимое массивов: ");

        // Первый массив
        FileReader fileReader1 = new FileReader("file1_for_Task6.txt");
        BufferedReader reader1 = new BufferedReader(fileReader1);

        String[] array1 = new String[5];

        for (int i=0; i<5; i++) {
            array1 [i] = reader1.readLine();
        }
        System.out.println(Arrays.toString(array1));

        // Второй массив
        FileReader fileReader2 = new FileReader("file2_for_Task6.txt");
        BufferedReader reader2 = new BufferedReader(fileReader2);

        String[] array2 = new String[5];

        for (int i=5; i<10; i++) {
            array2 [i-5] = reader2.readLine();
        }
        System.out.println(Arrays.toString(array2));

        System.out.println();
        System.out.println("Общий массив выглядит так: ");

        // Инициализируем общий массив, в котором 'склеим' два первых массива
        String[] resultArray = Stream.concat(Arrays.stream(array1),
                        Arrays.stream(array2))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(resultArray));
    }
}
