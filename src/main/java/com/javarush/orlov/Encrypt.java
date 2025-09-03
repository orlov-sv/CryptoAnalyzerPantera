package com.javarush.orlov;

import java.util.ArrayList;

public class Encrypt {

    // Алфавит, используемый для шифрования и дешифрования
    // Содержит русские буквы в нижнем и верхнем регистре, знаки препинания и пробел
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    // Шифрует или расшифровывает текст с помощью ключа
    // Если ключ положительный — шифрование, если отрицательный — расшифровка
    public ArrayList<String> encrypt(ArrayList<String> text, int key) {

        ArrayList<String> result = new ArrayList<>();

        // Обрабатываем каждую строку текста
        for (String s : text) {
            result.add(checkAlphabet(s, key));
        }

        return result;
    }

    // Проверяет каждый символ строки и сдвигает его по алфавиту
    private String checkAlphabet(String text, int key) {
        StringBuilder builder = new StringBuilder();

        // Перебираем символы строки
        for (int k = 0; k < text.length(); k++) {
            char current = text.charAt(k);

            // Проверяем, есть ли символ в алфавите
            boolean found = isFound(key, current, builder);

            // Если символа нет в алфавите — оставляем его без изменений
            if (!found) {
                builder.append(current);
            }
        }

        return builder.toString();
    }

    // Сдвигает символ по алфавиту на заданное количество позиций
    // Возвращает true, если символ найден в алфавите, иначе false
    private boolean isFound(int key, char current, StringBuilder builder) {
        for (int j = 0; j < ALPHABET.length; j++) { // перебор всех символов алфавита
            if (current == ALPHABET[j]) {
                // Сдвиг с учетом длины алфавита и обработки отрицательного ключа
                builder.append(ALPHABET[(j + key % ALPHABET.length + ALPHABET.length) % ALPHABET.length]);
                return true;
            }
        }
        return false;
    }

}
