import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task2_5_5 {
    public static void main(String[] args) throws IOException {
        System.out.println("Задание: \n5.\tПользователь вводит буквы. Пока не введёт букву ‘ю’, сохраняйте буквы " +
                "в массив char(nycTb в нем будет 100 элементов максимум). Потом создайте новый массив char размером " +
                "столько, сколько букв ввел пользователь. Скопируйте в него буквы из первого массива\n\nРешение: ");

        char[] chars = new char[100];
        String entered_Letter;
        int chars_Lenth_Real = 0;

        do {
            for (int i = 0; i < 100; i++) {
                System.out.print("Введите букву кириллицы, пример: 'э': ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                entered_Letter = reader.readLine();
                if (!entered_Letter.equals("ю")) {


                    System.out.println("Это не ю");
                    chars[i] = entered_Letter.charAt(0);
                    chars_Lenth_Real++;

                } else break;
            }
            break;
        } while (entered_Letter.equals("ю"));
        System.out.println();
        System.out.println("Введена буква 'ю'. Ввод букв завершен.");
        char[] chars2 = new char[chars_Lenth_Real];
        for (int i = 0; i < chars_Lenth_Real; i++) {
            chars2[i] = chars[i];
        }
        System.out.println();
        System.out.println("Второй массив, 'chars2', имеет следующий вид: " + Arrays.toString(chars2) + ", кол-во элементов в нем: " + chars_Lenth_Real);
        System.out.println();
        System.out.println("Конец программы");
    }
}
