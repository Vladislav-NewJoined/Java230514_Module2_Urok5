import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.String.valueOf;

public class Task2_5_7 {
    public static void main(String[] args) throws IOException {
        System.out.println("Задание: \n7.\tПоле чудес. Игрок один пишет слово. Выводится: ##### (по количеству букв) " +
                "Игрок два пытается угадать буквы. Если угадал, буква открывается: #а#а#, ба#а#, ... банан\n\nРешение: ");

        System.out.print("Первый игрок, введите слово с маленькой буквы, пример 'банан': ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word_Of_First_Player = reader.readLine();
        StringBuilder strBuilder = new StringBuilder();
        String guessedWord;

//            Создаем слово и массив с закрытыми буквами (вместо букв пишется символ '#') для первого игрока
        String[] letters_Closed = new String[word_Of_First_Player.length()];
        String currentLetter_Closed;

        for (int i = 0; i < word_Of_First_Player.length(); i++) {
            currentLetter_Closed = "#";
            letters_Closed[i] = currentLetter_Closed;
            strBuilder.append(letters_Closed[i]);
        }
        guessedWord = strBuilder.toString();
        System.out.println(guessedWord);

//            Создаем слово и массив с открытыми буквами для первого игрока
        char[] chars = new char[word_Of_First_Player.length()];
        String[] currentLetters = new String[word_Of_First_Player.length()];
        String currentLetter;

        for (int i = 0; i < word_Of_First_Player.length(); i++) {
            chars[i] = word_Of_First_Player.charAt(i);
            currentLetter = valueOf(chars[i]);
            currentLetters[i] = currentLetter;
        }
        System.out.println();
        do {

            System.out.print("Второй игрок, введите букву кириллицы: ");
            String letter_From_Second_Player = reader.readLine();

            guessedWord = guessedWord;
            for (int i = 0; i < guessedWord.length(); i++) {
                chars[i] = word_Of_First_Player.charAt(i);
                currentLetter = valueOf(chars[i]);

                if (letter_From_Second_Player.equals(currentLetter)) {
                    chars[i] = word_Of_First_Player.charAt(i);
                    letters_Closed[i] = letter_From_Second_Player;
                }
            }
            strBuilder = new StringBuilder();
            for (int i = 0; i < letters_Closed.length; i++) {
                strBuilder.append(letters_Closed[i]);
            }
            guessedWord = strBuilder.toString();
            System.out.println(guessedWord);
        }
        while (guessedWord.contains("#"));

        System.out.println("Слово отгадано");
    }
}