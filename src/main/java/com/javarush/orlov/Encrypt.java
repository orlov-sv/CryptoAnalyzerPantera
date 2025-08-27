package com.javarush.orlov;

import java.util.ArrayList;


public class Encrypt {
    // шифрование и дешифрование с помощью ключа
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', 'А', 'Б', 'В', 'Г', 'Д',
            'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н' , 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш',
            'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};




    public ArrayList<String> encrypt(ArrayList<String> text, int key){

        ArrayList<String> result = new ArrayList<>();

        for (String s : text) {
            result.add(checkAlphabet(s, key));
        }

        return result;
    }

    private String checkAlphabet(String text, int key){
        StringBuilder builder = new StringBuilder();

        for (int k = 0; k < text.length(); k++) {  // перебор символов строки
            char current = text.charAt(k);
            boolean found;

             found = isFound(key, current, builder);

            if (!found) { // если символа нет в алфавите — оставляем как есть
                builder.append(current);
            }
        }

        return builder.toString();
    }

    private boolean isFound(int key, char current, StringBuilder builder) {
        for (int j = 0; j < ALPHABET.length; j++) { // перебор алфавита
            if (current == ALPHABET[j]) {
                builder.append(ALPHABET[(j + key%ALPHABET.length + ALPHABET.length) % ALPHABET.length]);
                return true;
            }
        }
        return false;
    }

}
