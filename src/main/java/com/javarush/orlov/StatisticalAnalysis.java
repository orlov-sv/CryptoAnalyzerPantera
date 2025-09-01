package com.javarush.orlov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticalAnalysis {

    // Выполняет статистический анализ текста для взлома шифра Цезаря
    // Объединяет весь текст в одну строку, находит самый частый символ и расшифровывает текст
    public ArrayList<String> statisticalAnalysis(ArrayList<String> text){
        ArrayList<String> result = new ArrayList<>();

        // Объединяем все строки текста в одну для анализа частоты символов
        StringBuilder allText = new StringBuilder();
        for (String line : text) {
            allText.append(line);
        }

        // Находим самый часто встречающийся символ во всём тексте
        char top = word(allText.toString());

        // Вычисляем ключ шифра, предполагая, что самый частый символ — пробел
        int key = differenceWithSpace(top);

        // Расшифровываем текст с найденным ключом
        Decrypt decrypt = new Decrypt();
        result = decrypt.decrypt(text, key);

        return result;
    }

    // Находит символ, который встречается чаще всего в строке
    private char word(String line){
        HashMap<Character, Integer> count = new HashMap<>();

        // Подсчитываем количество каждого символа
        for (int j = 0; j < line.length(); j++) {
            char c = line.charAt(j);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        char mostFrequent = ' ';
        int maxCount = 0;

        // Определяем символ с максимальной частотой
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;
    }

    // Вычисляет ключ шифра Цезаря как разницу позиции самого частого символа и пробела
    // Если ключ отрицательный, корректирует его, добавляя длину алфавита
    public static int differenceWithSpace(char mostFrequent) {
        int indexMostFrequent = -1;
        int indexSpace = -1;

        // Находим позиции символов в алфавите
        for (int i = 0; i < Encrypt.ALPHABET.length; i++) {
            if (Encrypt.ALPHABET[i] == mostFrequent) {
                indexMostFrequent = i;
            }
            if (Encrypt.ALPHABET[i] == ' ') {
                indexSpace = i;
            }
        }

        // Если символы не найдены, выбрасываем исключение
        if (indexMostFrequent == -1 || indexSpace == -1) {
            throw new IllegalArgumentException("Символ не найден в алфавите");
        }

        // Вычисляем ключ
        int key = indexMostFrequent - indexSpace;
        if (key < 0) key += Encrypt.ALPHABET.length; // корректировка отрицательного ключа

        return key;
    }

}
