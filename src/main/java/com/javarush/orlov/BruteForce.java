package com.javarush.orlov;

import java.util.ArrayList;

public class BruteForce extends Encrypt {

    // Мини-словарь частых слов для проверки корректности расшифровки
    private static final String[] DICTIONARY = {"и", "в", "на", "что", "как", "это", "он", "она", "они"};

    // Метод перебирает все возможные ключи шифра Цезаря и выбирает лучший
    // Лучший ключ определяется по количеству слов из словаря, найденных в тексте
    public ArrayList<String> bruteForce(ArrayList<String> text) {
        ArrayList<String> result;
        int key = 0;       // ключ с наибольшим количеством совпадений
        int count = 0;     // максимальное количество совпадений слов из словаря

        // Перебираем все возможные ключи (все позиции алфавита)
        for (int i = 0; i < ALPHABET.length; i++) {
            result = super.encrypt(text, i);  // "расшифровываем" текст с текущим ключом
            int temp = extracted(result);     // подсчитываем совпадения слов из словаря
            if (temp > count) {
                key = i;      // если найдено больше совпадений, сохраняем ключ
                count = temp;
            }
        }

        // Возвращаем текст, расшифрованный с лучшим ключом
        return super.encrypt(text, key);
    }

    // Метод подсчитывает количество слов из словаря в списке строк
    private static int extracted(ArrayList<String> result) {
        int count = 0;

        // Перебираем все строки текста
        for (int j = 0; j < result.size(); j++) {
            count += checkWord(result.get(j)); // считаем совпадения слов из словаря в каждой строке
        }

        return count;
    }

    // Метод проверяет строку на наличие слов из словаря
    private static int checkWord(String str) {
        int count = 0;

        // Разбиваем строку на слова по пробелам
        String[] word = str.split(" ");

        for (int i = 0; i < word.length; i++) {
            // Убираем все символы кроме букв
            word[i] = word[i].replaceAll("[^а-яА-Я]", "");

            // Сравниваем слово с каждым словом из словаря (игнорируя регистр)
            for (int j = 0; j < DICTIONARY.length; j++) {
                if (word[i].equalsIgnoreCase(DICTIONARY[j])) {
                    count++;   // если совпадение найдено, увеличиваем счетчик
                }
            }
        }

        return count;
    }
}
