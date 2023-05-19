import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Task2_5_8 {
    public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Задание: \n8.\tПоле чудес с соревнованием. Генерируете 1000 случайных слов на сайте- " +
    "\nгенераторе (пример: https://sanstv.ru/randomWord, но в поисковике есть много подобных). " +
    "\nСохраняете их в файл. Из файла считываете случайное, и выводите ####. игроки по очереди отгадывают букву. " +
    "\nГласная - 1 балл, согласная - 2 балла, если буква встречается несколько раз - больше. " +
    "\nМожно угадать слово целиком - за каждую угаданную букву тогда начислять баллы(гласные 1, согласные 2). " +
    "\nЕсли не угадал- минус 3 балла.\n\nРешение: ");

        Scanner scanner_Letter = new Scanner(System.in); // видео мин 23.05

        //  Выбираем случайное слово из массива list_Of_Random_Words. инфо здесь: Метод третий взят.  https://translated.turbopages.org/proxy_u/en-ru.ru.213ba5e0-6465ba90-2379d590-74722d776562/https/www.geeksforgeeks.org/getting-random-elements-from-arraylist-in-java/
        List<String> list_Of_Random_Words = new ArrayList<>(Files.readAllLines(Paths.get("1000_Random_Words.txt")));
        Random random_method = new Random();
        int index = 0;
        for (int i = 0; i < list_Of_Random_Words.size(); i++)
        {
            index = random_method.nextInt(list_Of_Random_Words.size());
        }

        StringBuilder strBuilder = new StringBuilder();
        String word_For_Guess = list_Of_Random_Words.get(index);
        System.out.println("Слово для отгадывания: " + word_For_Guess);
        String word_With_Closed_Letters; /*= "#####";*/

//            Создаем массив из букв загаданного слова
        String[] array_Letters_Of_Word_With_Closed_Letters = new String[word_For_Guess.length()];
        String currentLetter_Closed;

        String entered_Letter;

        for (int i = 0; i < word_For_Guess.length(); i++) {
            currentLetter_Closed = "#";
            array_Letters_Of_Word_With_Closed_Letters[i] = currentLetter_Closed;
            strBuilder.append(array_Letters_Of_Word_With_Closed_Letters[i]);
        }

        System.out.print("Слово с закрытыми буквами: ");
        word_With_Closed_Letters = strBuilder.toString();
        System.out.println(word_With_Closed_Letters);
        System.out.println();

        // Инициализируем для каждого игрока 'банк' очков
        int bank1 = 0;
        int bank2 = 0;
        int increase_For_Whole_Word_1 = 0;
        int increase_For_Whole_Word_2 = 0;

        // Инициализируем массив гласных букв
        String[] vowel_Letters = {"а", "о", "э", "е", "и", "ы", "у", "ё", "ю", "я"};

        // Инициализируем массив согласных букв
        String[] consonant_Letters = {"б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ъ"};

        // Игроки начинают по очереди отгадывать буквы
        while (!word_With_Closed_Letters.equals(word_For_Guess)) {

            System.out.print("Первый игрок: введите строчную букву кириллицы: ");
            entered_Letter = scanner_Letter.nextLine();

            for (int i = 0; i < word_For_Guess.length(); i++) {
                if (entered_Letter.equals(valueOf(word_For_Guess.charAt(i)))) {
                    array_Letters_Of_Word_With_Closed_Letters[i] = entered_Letter;

                }
            }

            if (word_For_Guess.contains(entered_Letter) && !entered_Letter.equals("")) {
                System.out.println("Есть такая буква.");

                for (int i = 0; i < vowel_Letters.length; i++) {
                    String current1 = vowel_Letters[i];
                    if (current1.equals(entered_Letter)) {
                        bank1 = bank1 + 1;
                        increase_For_Whole_Word_1 = increase_For_Whole_Word_1 + 1;

                    }
                }

                for (int n = 0; n < consonant_Letters.length; n++) {
                    String current2 = consonant_Letters[n];
                    if (current2.equals(entered_Letter)) {
                        bank1 = bank1 + 2;
                        increase_For_Whole_Word_1 = increase_For_Whole_Word_1 + 2;
                    }
                }

                System.out.println("Количество очков у первого игрока: " + bank1);
                word_With_Closed_Letters = "";
                for (int i = 0; i < array_Letters_Of_Word_With_Closed_Letters.length; i++) {
                    word_With_Closed_Letters = word_With_Closed_Letters + array_Letters_Of_Word_With_Closed_Letters[i];
                }

                System.out.println("Слово с закрытыми буквами стало: ");
                System.out.println(word_With_Closed_Letters + "\n");
            } else {
                System.out.println("Такой буквы нет.");
                bank1 = bank1 - 3;
                System.out.println("Количество очков у первого игрока: " + bank1 + "\n");

            }
            if (word_With_Closed_Letters.equals(word_For_Guess)) {
                System.out.println("Слово отгадано первым игроком, конец программы.");
                bank1 = bank1 + increase_For_Whole_Word_1;
                System.out.println("Итоговое количество очков у первого игрока: " + bank1);
                System.out.println("Итоговое количество очков у второго игрока: " + bank2);
                System.exit(0);
            }


            System.out.print("Второй игрок: введите строчную букву кириллицы: ");
            entered_Letter = scanner_Letter.nextLine();

            for (int i = 0; i < word_For_Guess.length(); i++) {
                if (entered_Letter.equals(valueOf(word_For_Guess.charAt(i)))) {
                    array_Letters_Of_Word_With_Closed_Letters[i] = entered_Letter;

                }
            }

            if (word_For_Guess.contains(entered_Letter) && !entered_Letter.equals("")) {
                System.out.println("Есть такая буква.");
                for (int i = 0; i < vowel_Letters.length; i++) {
                    String current1 = vowel_Letters[i];
                    if (current1.equals(entered_Letter)) {
                        bank2 = bank2 + 1;
                        increase_For_Whole_Word_2 = increase_For_Whole_Word_2 + 1;

                    }
                }

                for (int n = 0; n < consonant_Letters.length; n++) {
                    String current2 = consonant_Letters[n];
                    if (current2.equals(entered_Letter)) {
                        bank2 = bank2 + 2;
                        increase_For_Whole_Word_2 = increase_For_Whole_Word_2 + 2;
                    }
                }

                System.out.println("Количество очков у второго игрока: " + bank2);
                word_With_Closed_Letters = "";
                for (int i = 0; i < array_Letters_Of_Word_With_Closed_Letters.length; i++) {
                    word_With_Closed_Letters = word_With_Closed_Letters + array_Letters_Of_Word_With_Closed_Letters[i];
                }

                System.out.println("Слово с закрытыми буквами стало: ");
                System.out.println(word_With_Closed_Letters + "\n");
            } else {
                System.out.println("Такой буквы нет.");
                bank2 = bank2 - 3;
                System.out.println("Количество очков у второго игрока: " + bank2 + "\n");

            }
            if (word_With_Closed_Letters.equals(word_For_Guess)) {
                System.out.println("Слово отгадано вторым игроком, конец программы.");
                bank2 = bank2 + increase_For_Whole_Word_2;
                System.out.println("Итоговое количество очков у первого игрока: " + bank1);
                System.out.println("Итоговое количество очков у второго игрока: " + bank2);
                System.exit(0);
            }
        }
    }
}
