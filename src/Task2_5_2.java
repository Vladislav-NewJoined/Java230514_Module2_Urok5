public class Task2_5_2 {
    public static void main(String[] args) {
        System.out.println("Задание: \n2.	Сохраните 10 чисел в массив, выведите их с конца\n\nРешение: ");

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 9; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }
}
